package com.example.service;

import com.example.DTO.HistoryResultDTO;
import com.example.dao.*;
import com.example.entity.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HistoryService {
    private final ResultDao resultDao;
    private final HistoryDao historyDao;

    private final SubjectDao subjectDao;

    private final ExamDao examDao;

    private final QuestionDao questionDao;


    public HistoryService(ResultDao resultDao, HistoryDao historyDao, SubjectDao subjectDao, ExamDao examDao, QuestionDao questionDao) {
        this.resultDao = resultDao;
        this.historyDao = historyDao;
        this.subjectDao = subjectDao;
        this.examDao = examDao;
        this.questionDao = questionDao;
    }




    public List<HistoryResultDTO> getAllHistoriesOfUser(int idUser){
        // lay history
        List<History> histories = historyDao.findAllHistoriesOfUser(idUser);

        // Neu rong thi tra ve loi luon
        if(histories.isEmpty()){
            throw new IllegalArgumentException("History is empty!");
        }

        // lay them thong tin result tuong ung voi cac lich su . result - history la moi quan he 1 : 1
        List<Result> results = resultDao.findAllResultCorrespondingHistory(histories);

        // Tu results se lay duoc cac bai kiem tra da lam
//        List<Exam> exams = examDao.findAllExamSubmitted(results);

        // tu cac bai kiem tra da lam se lay duoc bai kiem tra thuoc mon hoc nao
//        List<Subject> subjects = subjectDao.findAllSubjectFromExam(exams);


        // form data time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");


        int size = results.size();

        List<HistoryResultDTO> res = new ArrayList<>();

        for(int i = 0;i < size;++i){
            // lay thong tin cua Histories
            LocalDateTime startTime = histories.get(i).getStartTime();
            LocalDateTime endTime = histories.get(i).getEndTime();
            String isoStartTime = startTime.format(formatter);
            String isoEndTime = endTime.format(formatter);

            // lay thong tin cua res
            Result result = results.get(i);
            double score = result.getScore();

            // lay thong tin cua exam
            int idExam = result.getIdExam();
            Exam exam = examDao.findById(idExam);
            String nameExam = exam.getNameExam();
            int timeLimit = exam.getTimeLimit();

            // lay thong tin so luong cau hoi trong bai kiem tra
            List<Question> questionsOfExam = questionDao.findAllQuestionOfExam(idExam);
            int numQuestions = questionsOfExam.size();
            int numCorrectAnswer = (int)(numQuestions * score) / 10;

            // lay thong tin cua mon hoc trong bai kiem tra
            int idSubject = exam.getIdSubject();
            Subject subject = subjectDao.findById(idSubject);
            String nameSubject = subject.getNameSubject();

            res.add(new HistoryResultDTO(nameExam,nameSubject,numQuestions,timeLimit,numCorrectAnswer,isoStartTime,isoEndTime,score));
        }
        return res;
    }
}
