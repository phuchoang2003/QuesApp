package com.example.service;

import com.example.CustomExceptionHandling.CreateFailedHistory;
import com.example.CustomExceptionHandling.CreatingFailedExam;
import com.example.CustomExceptionHandling.ValidationQuestion;
import com.example.DTO.*;
import com.example.dao.*;
import com.example.entity.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExamService {
    private final ExamDao examDao;

    private final HistoryDao historyDao;

    private final ResultDao resultDao;

    private final QuestionDao questionDao;

    private final AnswerDao answerDao;

    public ExamService(ExamDao examDao, HistoryDao historyDao, ResultDao resultDao, QuestionDao questionDao, AnswerDao answerDao) {
        this.examDao = examDao;
        this.historyDao = historyDao;
        this.resultDao = resultDao;
        this.questionDao = questionDao;
        this.answerDao = answerDao;
    }


    // tao bai kiem tra
    public ExamQuestionIdsDTO createExamOfSubject(int idSubject, ExamQuestionIdsDTO examQuestionIdsDTO) {
        try {
            List<String> questionIds = examQuestionIdsDTO.getQuestionIds();
            // phai co it nhat 1 question trong exam thi moi duoc tao
            if (questionIds == null || questionIds.isEmpty()) {
                throw new ValidationQuestion("Exam must have at least one question!", new IllegalArgumentException());
            }

            List<Integer> listIds = questionIds.stream()
                    .map(Integer::parseInt)
                    .toList();

            Exam exam = examQuestionIdsDTO.convertToExam();
            exam.setIdSubject(idSubject);

            boolean allQuestionIdsValid = true;
            for (int questionId : listIds) {
                if (questionId <= 0) {
                    allQuestionIdsValid = false;
                    break;
                }

                Question question = questionDao.findById(questionId);
                if (question == null || question.getIdSubject() != idSubject) {
                    allQuestionIdsValid = false;
                    break;
                }
            }

            if (!allQuestionIdsValid) {
                throw new ValidationQuestion("Some question Id are invalid!", new IllegalArgumentException());
            }

            Exam finalExam = examDao.create(exam);
            int idResultExam = finalExam.getIdExam();
            questionDao.addQuestionsToExam(listIds,idResultExam);

            return new ExamQuestionIdsDTO(finalExam.getNameExam(), finalExam.getTimeLimit(), questionIds);
        } catch (IllegalArgumentException e) {
            throw new ValidationQuestion(e.getMessage(),e);
        } catch (Exception e) {
            throw new CreatingFailedExam(e.getMessage(), e);
        }
    }


    // Xoa bai kiem tra theo id
    public boolean deleteExamById(int idExam){
        List<Result> results = resultDao.findAllResultOfExam(idExam);
        results.stream()
                .forEach(result -> {
                    int idResult = result.getIdResult();
                    historyDao.deleteHistoryByResult(idResult);
                    resultDao.deleteById(idResult);
                });

        return examDao.deleteById(idExam);
    }


    // lam bai kiem tra
    public ExamQuestionDetailsDTO takeExam(int idExam){
        // tu idExam lay ra danh sach cau hoi va cau tra loi tuong ung
        List<Question> allQuestions = questionDao.findAllQuestionOfExam(idExam);
        List<QuestionAnswerDTO> allQuestionOfExam = new ArrayList<>();
        for(var question : allQuestions){
            int idQuestion = question.getIdQuestion();
            List<Answer> answerOfQuestion = answerDao.findAllAnswerByQuestion(idQuestion);
            QuestionAnswerDTO questionAnswerDTO = new QuestionAnswerDTO(question.getContent(),answerOfQuestion,idQuestion);
            allQuestionOfExam.add(questionAnswerDTO);
        }

        // tu idExam lay ra exam va bat dau tinh gio dem nguoc
        Exam exam = examDao.findById(idExam);

        // Lay thoi gian bat dau lam bai
        LocalDateTime startTime = LocalDateTime.now();
        int timeLimit = exam.getTimeLimit() / 60;
        LocalDateTime endTime = startTime.plus(timeLimit, ChronoUnit.MINUTES);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String isoStartTime = startTime.format(formatter);
        String isoEndTime = endTime.format(formatter);

        ExamQuestionDetailsDTO examQuestionDetailsDTO = new ExamQuestionDetailsDTO(
                exam.getNameExam(),
                exam.getTimeLimit(),
                allQuestionOfExam
        );

        return examQuestionDetailsDTO;
    }

    // nop bai kiem tra => tao result va history
    public void submitExam(int idExam ,int idUser ,LocalDateTime startTime, SubmitExamDTO submitExamDTO) {
        LocalDateTime currentTime = LocalDateTime.now();
        double score = calcScore(idExam, submitExamDTO);
        try{
            // Tao result
            Result result = new Result();
            result.setIdExam(idExam);
            result.setScore(score);
            Result currentRes = resultDao.create(result);

            if(currentRes != null){
                // Tao history
                History history = new History();
                history.setIdUser(idUser);
                history.setIdResult(currentRes.getIdResult());

                // set thoi gian
                history.setEndTime(currentTime);
                history.setStartTime(startTime);

                History currentHis = historyDao.create(history);
            }
            else{
                throw new CreateFailedHistory("Failed to create history!");
            }

        }
        catch (Exception e){
            throw new CreateFailedHistory(e.getMessage(),e);
        }
    }

    // ham private tinh score => luu score vao result
    private double calcScore(int idExam , SubmitExamDTO submitExamDTO) {
        int numQuestion = questionDao.findAllQuestionOfExam(idExam).size();
        int numCorrectQuestion = 0;
        for (var answerUser : submitExamDTO.getAnswersUser()) {
            Answer answer = answerDao.findById(answerUser.getSelectedAnswerId());
            if (answer != null && answer.isCorrect()) {
                ++numCorrectQuestion;
            }
        }
        return (numQuestion > 0) ? ((double) numCorrectQuestion / numQuestion) * 10 : 0;
    }


    public List<ExamDTO> getAllExamsOfSubject(int idSubject){
        List<Exam> exams = examDao.findAllExamOfSubject(idSubject);

        return exams.stream()
                .map(exam -> {
                    List<Question> questions = questionDao.findAllQuestionOfExam(exam.getIdExam());
                    int numberQuestion = questions.size();
                    return new ExamDTO(exam.getNameExam(),numberQuestion,exam.getTimeLimit(),exam.getIdExam());
                }).collect(Collectors.toList());
    }




}
