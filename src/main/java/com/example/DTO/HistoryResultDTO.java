package com.example.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class HistoryResultDTO {
    private String nameExam;
    private String nameSubject;

    private int numberQuestion;

    private int timeLimit;

    private int numberCorrectAnswer;

    private String startTime;
    private String endTime;

    public String getNameExam() {
        return nameExam;
    }

    public void setNameExam(String nameExam) {
        this.nameExam = nameExam;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
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

    public int getNumberCorrectAnswer() {
        return numberCorrectAnswer;
    }

    public void setNumberCorrectAnswer(int numberCorrectAnswer) {
        this.numberCorrectAnswer = numberCorrectAnswer;
    }

    private double score;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    @JsonCreator
    public HistoryResultDTO(@JsonProperty("nameExam") String nameExam,@JsonProperty("nameSubject") String nameSubject,@JsonProperty("numberQuestion") int numberQuestion,@JsonProperty("timeLimit") int timeLimit,@JsonProperty("numberCorrectAnswer") int numberCorrectAnswer, @JsonProperty("startTime") String startTime,
                            @JsonProperty("endTime")String endTime,
                            @JsonProperty("score") double score) {
        this.nameExam = nameExam;
        this.nameSubject = nameSubject;
        this.numberQuestion = numberQuestion;
        this.timeLimit = timeLimit;
        this.numberCorrectAnswer = numberCorrectAnswer;
        this.startTime = startTime;
        this.endTime = endTime;
        this.score = score;
    }
}
