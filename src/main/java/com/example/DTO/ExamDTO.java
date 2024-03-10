package com.example.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExamDTO {
    private String nameExam;
    private int numberQuestion;

    private int timeLimit;

    private int idExam;

    public int getIdExam() {
        return idExam;
    }

    public void setIdExam(int idExam) {
        this.idExam = idExam;
    }

    @JsonCreator
    public ExamDTO(@JsonProperty("nameExam") String nameExam,@JsonProperty("numberQuestion") int numberQuestion,@JsonProperty("timeLimit") int timeLimit,@JsonProperty("idExam") int idExam) {
        this.nameExam = nameExam;
        this.numberQuestion = numberQuestion;
        this.timeLimit = timeLimit;
        this.idExam = idExam;
    }

    public String getNameExam() {
        return nameExam;
    }

    public void setNameExam(String nameExam) {
        this.nameExam = nameExam;
    }

    public int getNumberQuestion() {
        return numberQuestion;
    }

    public void setNumberQuestion(int numberQuestion) {
        this.numberQuestion = numberQuestion;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }
}
