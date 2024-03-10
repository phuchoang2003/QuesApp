package com.example.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {
    private int idAnswer;
    private String contentOption;
    private boolean isCorrect;
    private int idQuestion;

    public Answer() {
    }

    @JsonCreator
    public Answer(
            @JsonProperty("idAnswer") int idAnswer,
            @JsonProperty("contentOption") String contentOption,
            @JsonProperty("isCorrect") boolean isCorrect,
            @JsonProperty("idQuestion") int idQuestion) {
        this.idAnswer = idAnswer;
        this.contentOption = contentOption;
        this.isCorrect = isCorrect;
        this.idQuestion = idQuestion;
    }


    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getContentOption() {
        return contentOption;
    }

    public void setContentOption(String contentOption) {
        this.contentOption = contentOption;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }
}
