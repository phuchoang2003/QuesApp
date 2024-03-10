package com.example.dao;

import com.example.entity.History;

import java.util.List;

public interface HistoryDao extends Dao<History>{
    List<History> findAllHistoriesOfUser(int idUser);

    boolean deleteHistoryByResult(int idResult);

    History findHistoryByResult(int idResult);
}
