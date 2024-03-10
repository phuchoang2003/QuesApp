package com.example.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    private int idResult;
    private int idExam;
    private double score;

    public Result() {
    }

    @JsonCreator
    public Result(@JsonProperty("id_result") int idResult, @JsonProperty("id_exam") int idExam,@JsonProperty("score") double score) {
        this.idResult = idResult;
        this.idExam = idExam;
        this.score = score;
    }

    public int getIdResult() {
        return idResult;
    }

    public void setIdResult(int idResult) {
        this.idResult = idResult;
    }

    public int getIdExam() {
        return idExam;
    }

    public void setIdExam(int idExam) {
        this.idExam = idExam;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
