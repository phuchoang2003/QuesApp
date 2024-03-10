package com.example.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;

public class ExamQuestionDetailsDTO {
    private String nameExam;
    private int timeLimit;
    private List<QuestionAnswerDTO> questionAnswerDTOS;




    @JsonCreator
    public ExamQuestionDetailsDTO(@JsonProperty("nameExam") String nameExam,@JsonProperty("timeLimit") int timeLimit, @JsonProperty("questions") List<QuestionAnswerDTO> questionAnswerDTOS) {
        this.nameExam = nameExam;
        this.timeLimit = timeLimit;
        this.questionAnswerDTOS = questionAnswerDTOS;
    }

    public String getNameExam() {
        return nameExam;
    }

    public void setNameExam(String nameExam) {
        this.nameExam = nameExam;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public List<QuestionAnswerDTO> getQuestionAnswerDTOS() {
        return questionAnswerDTOS;
    }

    public void setQuestionAnswerDTOS(List<QuestionAnswerDTO> questionAnswerDTOS) {
        this.questionAnswerDTOS = questionAnswerDTOS;
    }
}
