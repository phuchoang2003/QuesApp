package com.example.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Subject {
    private String nameSubject;

    private int id;

    private int idUser;

    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject() {
    }

    @JsonCreator
    public Subject(@JsonProperty("nameSubject") String nameSubject,@JsonProperty("id_subject") int id, @JsonProperty("idUser") int idUser) {
        this.nameSubject = nameSubject;
        this.id = id;
        this.idUser = idUser;
    }



    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }


    @Override
    public String toString() {
        return "{ nameSubject= " + nameSubject + ", id= " + id +", idUser= " + idUser + '}';
    }
}
