package com.example.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Exam {
    private int idExam;
    private int timeLimit;

    private int idSubject;
    private String nameExam;

    public Exam() {
    }


    public String getNameExam() {
        return nameExam;
    }

    public void setNameExam(String nameExam) {
        this.nameExam = nameExam;
    }

    @JsonCreator
    public Exam(@JsonProperty("id_exam") int idExam,@JsonProperty("nameExam") String nameExam, @JsonProperty("timeLimit") int timeLimit, @JsonProperty("id_subject") int idSubject) {
        this.idExam = idExam;
        this.timeLimit = timeLimit;
        this.idSubject = idSubject;
        this.nameExam = nameExam;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public int getIdExam() {
        return idExam;
    }

    public void setIdExam(int idExam) {
        this.idExam = idExam;
    }


    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }
}
