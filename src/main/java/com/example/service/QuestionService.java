package com.example.service;

import com.example.DTO.QuestionAnswerDTO;
import com.example.dao.AnswerDao;
import com.example.dao.QuestionDao;
import com.example.entity.Answer;
import com.example.entity.Question;
import java.util.List;

public class QuestionService {
    private final QuestionDao questionDao;

    private final AnswerDao answerDao;


    public QuestionService(QuestionDao questionDao, AnswerDao answerDao) {
        this.questionDao = questionDao;
        this.answerDao = answerDao;
    }

    public QuestionAnswerDTO createQuestionOfSubject(int idSubject,QuestionAnswerDTO questionAnswerDTO) {
        try {
            // Convert DTO to model
            List<Answer> answers = questionAnswerDTO.getAnswers();
            Question question = questionAnswerDTO.convertDtoToQuestion();
            question.setIdSubject(idSubject);

            // Validate input data
            validateQuestionAndAnswers(question, answers);

            // Question must have 1 correct answer
            int correctAnswersCount = (int) answers.stream().filter(Answer::isCorrect).count();
            if (correctAnswersCount != 1) {
                throw new IllegalArgumentException("Question must have exactly 1 correct answer.");
            }

            try {
                Question questionCurrent = questionDao.create(question);
                for (var answer : answers) {
                    // validate answer
                    if (answer.getContentOption() == null || answer.getContentOption().isEmpty()) {
                        throw new IllegalArgumentException("Answer content cannot be null or empty.");
                    }
                    answer.setIdQuestion(questionCurrent.getIdQuestion());
                    Answer answerCurrent = answerDao.create(answer);
                    if(answerCurrent == null) throw new RuntimeException("Question created failed");
                }
                return new QuestionAnswerDTO(questionCurrent.getContent(),answers,questionCurrent.getIdQuestion());
            } catch (Exception e) {
                throw new RuntimeException("Error creating question and answers in the database.", e);
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid input data.", e);
        }
    }

    private void validateQuestionAndAnswers(Question question, List<Answer> answers) {
        // Question must have 4 answer
        if (question == null || question.getContent() == null || answers == null || answers.size() != 4) {
            throw new IllegalArgumentException("Invalid question or answers.");
        }
    }



    public List<QuestionAnswerDTO> findAllQuestionsOfSubject(int idSubject) {
        List<Question> allQuestions = questionDao.findAllQuestionBySubject(idSubject);

        return allQuestions.stream()
                .map(question -> {
                    int idQuestion = question.getIdQuestion();
                    List<Answer> answerOfQuestion = answerDao.findAllAnswerByQuestion(idQuestion);
                    return new QuestionAnswerDTO(question.getContent(),answerOfQuestion,idQuestion);
                }).toList();
    }



    // ver 1
//    public List<QuestionAnswerDTO> findAllQuestionsOfSubject(int idSubject){
//        List<Question> allQuestions = questionDao.findAllQuestionBySubject(idSubject);
//        List<QuestionAnswerDTO> allQuestionOfSubject = new ArrayList<>();
//
//        for(var question : allQuestions){
//                int idQuestion = question.getIdQuestion();
//                List<Answer> answerOfQuestion = answerDao.findAllAnswerByQuestion(idQuestion);
//                QuestionAnswerDTO questionAnswerDTO = new QuestionAnswerDTO(question.getContent(),answerOfQuestion);
//                allQuestionOfSubject.add(questionAnswerDTO);
//        }
//        return allQuestionOfSubject;
//    }



    public QuestionAnswerDTO updateQuestionById(int idOldQuestion,QuestionAnswerDTO questionAnswerDTO){
        try{
            // GET old question and old answers
            Question question = questionDao.findById(idOldQuestion);
            List<Answer> answers = answerDao.findAllAnswerByQuestion(idOldQuestion);

            //GET content new question and update question
            Question newQuestion = questionAnswerDTO.convertDtoToQuestion();

            // GET content new answers and update old answer
            List<Answer> newAnswers = questionAnswerDTO.getAnswers();

            // Validate
            validateQuestionAndAnswers(question, answers);

            int correctAnswersCount = (int) newAnswers.stream().filter(Answer::isCorrect).count();
            if (correctAnswersCount != 1) {
                throw new IllegalArgumentException("Question must have exactly 1 correct answer.");
            }


            // Update
            question.setContent(newQuestion.getContent());
            questionDao.updateById(idOldQuestion,question);

            for(int i = 0; i < newAnswers.size();++i){
                // validate answer
                if (newAnswers.get(i).getContentOption() == null || newAnswers.get(i).getContentOption().isEmpty()) {
                    throw new IllegalArgumentException("Answer content cannot be null or empty.");
                }
                String newContentAnswer = newAnswers.get(i).getContentOption();
                boolean isCorrectAnswer = newAnswers.get(i).isCorrect();
                answers.get(i).setContentOption(newContentAnswer);
                answers.get(i).setCorrect(isCorrectAnswer);
                int idAnswer = answers.get(i).getIdAnswer();
                answerDao.updateById(idAnswer,answers.get(i));
            }
            return new QuestionAnswerDTO(question.getContent(),answers,idOldQuestion);

        }
        catch (IllegalArgumentException e){
            throw e;
        }
        catch (Exception e){
            throw new RuntimeException("Update failed Question due to database error");
        }
    }

    public boolean deleteQuestionById(int idQuestion){
        return answerDao.deleteAllAnswerByQuestion(idQuestion) && questionDao.deleteById(idQuestion);
    }


    public List<QuestionAnswerDTO> getAllQuestionSelectedToAddExam(List<Integer> listIds){
        List<Question> questions = questionDao.findAlQuestionsByListId(listIds);
        return questions.stream()
                .map(question -> {
                    int idQuestion = question.getIdQuestion();
                    List<Answer> answers = answerDao.findAllAnswerByQuestion(idQuestion);
                    return new QuestionAnswerDTO(question.getContent(),answers,idQuestion);
                }).toList();
    }


}
