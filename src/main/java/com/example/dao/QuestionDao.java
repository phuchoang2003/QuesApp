package com.example.dao;

import com.example.entity.Question;

import java.util.List;

public interface QuestionDao extends Dao<Question> {
    List<Question> findAllQuestionBySubject(int idSubject);

    List<Question> findAllQuestionOfExam(int idExam);

    void addQuestionsToExam(List<Integer> idQuestions,int idExam);

    void removeQuestionFromExam(int idQuestion,int idExam);

    List<Question> findAlQuestionsByListId(List<Integer> listIds);

}
