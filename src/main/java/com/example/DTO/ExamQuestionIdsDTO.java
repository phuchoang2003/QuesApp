package com.example.DTO;

import com.example.entity.Exam;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ExamQuestionIdsDTO {
        private String nameExam;
        private int timeLimit;
        private List<String> questionIds;

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

    @JsonCreator
        public ExamQuestionIdsDTO(@JsonProperty("nameExam") String nameExam, @JsonProperty("timeLimit") int timeLimit, @JsonProperty("questionIds") List<String> questionIds) {
            this.nameExam = nameExam;
            this.timeLimit = timeLimit;
            this.questionIds = questionIds;
        }


        public List<String> getQuestionIds() {
            return questionIds;
        }

        public void setQuestionIds(List<String> questionIds) {
            this.questionIds = questionIds;
        }

    public Exam convertToExam(){
        Exam exam = new Exam();
        exam.setNameExam(this.getNameExam());
        exam.setTimeLimit(this.getTimeLimit());
        return exam;
    }
}
