package com.example.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Date;

public class History {
    private int idHistory;
    private int idUser;
    private int idResult;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public History() {
    }

    @JsonCreator
    public History(@JsonProperty("id_history") int idHistory,@JsonProperty("id_result") int idResult,@JsonProperty("startTime") LocalDateTime startTime, @JsonProperty("endTime") LocalDateTime endTime, @JsonProperty("id_user") int idUser) {
        this.idHistory = idHistory;
        this.idResult = idResult;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(int idHistory) {
        this.idHistory = idHistory;
    }

    public int getIdResult() {
        return idResult;
    }

    public void setIdResult(int idResult) {
        this.idResult = idResult;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
