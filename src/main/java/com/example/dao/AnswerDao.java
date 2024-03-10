package com.example.dao;

import com.example.entity.Answer;

import java.util.List;

public interface AnswerDao extends Dao<Answer>{
    List<Answer> findAllAnswerByQuestion(int idQuestion);
    boolean deleteAllAnswerByQuestion(int idQuestion);

}
