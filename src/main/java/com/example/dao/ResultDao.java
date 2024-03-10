package com.example.dao;

import com.example.entity.History;
import com.example.entity.Result;

import java.util.List;

public interface ResultDao extends Dao<Result>{
    List<Result> findAllResultCorrespondingHistory(List<History> histories);

    boolean deleteResultsByExamId(int idExam);

    List<Result> findAllResultOfExam(int idExam);
}
