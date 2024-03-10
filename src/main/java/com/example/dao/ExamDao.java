package com.example.dao;

import com.example.entity.Exam;
import com.example.entity.Result;

import java.util.List;

public interface ExamDao extends Dao<Exam>{
    List<Exam> findAllExamOfSubject(int idSubject);
    List<Exam> findAllExamOfUser(int idUser);


    // tim cac bai kiem tra tu result tuong tung
    List<Exam> findAllExamSubmitted(List<Result> idResults);

    boolean deleteAllExamByIdSubject(int idSubject);
}
