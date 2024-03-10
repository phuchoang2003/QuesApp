package com.example.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {
        private int idQuestion;
        private String content;
        private int idSubject;

        public Question() {
        }

        @JsonCreator
        public Question( @JsonProperty("id_question") int idQuestion,@JsonProperty("content") String content,@JsonProperty("id_subject") int idSubject) {
                this.idQuestion = idQuestion;
                this.content = content;
                this.idSubject = idSubject;
        }


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

        public int getIdSubject() {
                return idSubject;
        }

        public void setIdSubject(int idSubject) {
                this.idSubject = idSubject;
        }
}
