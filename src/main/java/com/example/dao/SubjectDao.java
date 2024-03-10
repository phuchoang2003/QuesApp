package com.example.dao;

import com.example.entity.Exam;
import com.example.entity.Subject;

import java.util.List;


public interface SubjectDao extends Dao<Subject> {
    Subject findByName(String name, int idUser);
    List<Subject> findAllSubjetsOfUser(int idUser);

    List<Subject> findAllSubjectFromExam(List<Exam> listExam);



}
