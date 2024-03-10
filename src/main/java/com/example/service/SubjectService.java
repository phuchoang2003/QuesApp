package com.example.service;


import com.example.ExceptionHandling.DuplicateSubjectException;
import com.example.dao.ExamDao;
import com.example.dao.SubjectDao;
import com.example.entity.Subject;
import java.util.List;

public class SubjectService {
    private final SubjectDao subjectDao;

    private final ExamDao examDao;
    public SubjectService(SubjectDao subjectDao, ExamDao examDao) {
        this.subjectDao = subjectDao;
        this.examDao = examDao;
    }


    public Subject createSubjectOfUser(Subject subject) {
        try {
            // Check if user already has that subject
            Subject existingSubject = subjectDao.findByName(subject.getNameSubject(), subject.getIdUser());

            if (existingSubject != null) {
                throw new DuplicateSubjectException("Subject already exists for user " + subject.getIdUser());
            } else {
                // Create the subject if it doesn't exist
                Subject subjectCurrent = subjectDao.create(subject);
                if(subjectCurrent == null) throw new RuntimeException("Create subject failed due to a database error");
                return subjectCurrent;
            }
        } catch (DuplicateSubjectException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Create subject failed due to a database error", e);
        }
    }


    public List<Subject> getAllSubjectsByUser(int idUser){
            return subjectDao.findAllSubjetsOfUser(idUser);
    }

    public Subject getSubjectUserByName(String name,int idUser){
        return subjectDao.findByName(name,idUser);
    }


    public boolean deleteSubjectById(int id){
        return examDao.deleteAllExamByIdSubject(id) && subjectDao.deleteById(id);
    }

    public Subject updateSubjectById(int id, Subject newSubject){
        return subjectDao.updateById(id,newSubject);
    }


}
