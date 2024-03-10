package com.example.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SubmitExamDTO {

    private List<AnswerUserDTO> answersUser;



    public List<AnswerUserDTO> getAnswersUser() {
        return answersUser;
    }

    public void setAnswersUser(List<AnswerUserDTO> answersUser) {
        this.answersUser = answersUser;
    }

    @JsonCreator
    public SubmitExamDTO(@JsonProperty("answersUser") List<AnswerUserDTO> answersUser) {
        this.answersUser = answersUser;
    }
}
