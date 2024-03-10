package com.example.DTO;

import com.example.entity.Answer;
import com.example.entity.Question;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QuestionAnswerDTO  {




    @JsonCreator
    public QuestionAnswerDTO(@JsonProperty("content") String content, @JsonProperty("answers") List<Answer> answers, @JsonProperty("idQuestion") int idQuestion){
        this.content = content;
        this.answers = answers;
        this.idQuestion = idQuestion;
    }

    private int idQuestion;

    private List<Answer> answers;
    private String content;

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question convertDtoToQuestion(){
        Question question = new Question();
        question.setContent(this.getContent());
        return question;
    }
}
