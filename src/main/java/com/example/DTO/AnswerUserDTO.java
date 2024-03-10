package com.example.DTO;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;



public class AnswerUserDTO {

    private int idQuestion;
    private int selectedAnswerId;

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getSelectedAnswerId() {
        return selectedAnswerId;
    }

    public void setSelectedAnswerId(int selectedAnswerId) {
        this.selectedAnswerId = selectedAnswerId;
    }

    @JsonCreator
    public AnswerUserDTO(@JsonProperty("idQuestion") int idQuestion,@JsonProperty("selectedAnswerId") int selectedAnswerId) {
        this.idQuestion = idQuestion;
        this.selectedAnswerId = selectedAnswerId;

    }

}

