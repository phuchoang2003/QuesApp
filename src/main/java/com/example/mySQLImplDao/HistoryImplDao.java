package com.example.mySQLImplDao;

import com.example.CustomExceptionHandling.*;
import com.example.DataSource.ConnectionPool;
import com.example.dao.HistoryDao;
import com.example.entity.History;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoryImplDao implements HistoryDao {
    @Override
    public History findHistoryByResult(int idResult) {
        String query = "SELECT * FROM history WHERE id_result = ?";
        History history = null;
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idResult);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // set time
                    Timestamp startTimeTimestamp = resultSet.getTimestamp("start_time");
                    Timestamp endTimeTimestamp = resultSet.getTimestamp("end_time");
                    // Convert Timestamp to LocalDateTime
                    LocalDateTime startTime = startTimeTimestamp.toLocalDateTime();
                    LocalDateTime endTime = endTimeTimestamp.toLocalDateTime();


                    history.setStartTime(startTime);
                    history.setEndTime(endTime);
                    history.setIdUser(resultSet.getInt("id_user"));
                    history.setIdHistory(resultSet.getInt("id_history"));
                    history.setIdResult(idResult);
                }
            }
        } catch (SQLException e) {
            throw new NotFoundHistory("Error finding history by id with result's id: " + idResult, e);
        }

        return history;
    }

    @Override
    public boolean deleteHistoryByResult(int idResult) {
        String query = "DELETE FROM history WHERE id_result = ?";
        try(Connection connection = ConnectionPool.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,idResult);
            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected > 0) return true;
        }
        catch (SQLException e) {
            throw new DeleteFailedHistory("Delete history failed with result's id: " + idResult, e);
        }
        return false;
    }

    @Override
    public List<History> findAllHistoriesOfUser(int idUser) {
        String query = "SELECT * FROM history WHERE id_user = ?";
        List<History> histories = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idUser);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int idResult = resultSet.getInt("id_result");
                    Timestamp startTimeTimestamp = resultSet.getTimestamp("start_time");
                    Timestamp endTimeTimestamp = resultSet.getTimestamp("end_time");

                    // Convert Timestamp to LocalDateTime
                    LocalDateTime startTime = startTimeTimestamp.toLocalDateTime();
                    LocalDateTime endTime = endTimeTimestamp.toLocalDateTime();

                    int idHistory = resultSet.getInt("id_history");
                    var history = new History(idHistory, idResult, startTime, endTime, idUser);
                    histories.add(history);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NotFoundHistory("Error finding histories of user with user's id: " + idUser, e);
        }

        return histories;
    }


    @Override
    public History create(History history)  {
        String query = "INSERT INTO history (id_result, start_time, end_time,id_user) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, history.getIdResult());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(history.getStartTime()));
            preparedStatement.setTimestamp(3, Timestamp.valueOf(history.getEndTime()));
            preparedStatement.setInt(4,history.getIdUser());
            preparedStatement.executeUpdate();


            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    // 1 is the column index of the generated key
                    history.setIdHistory(resultSet.getInt(1));
                } else {
                    throw new SQLException("Creating history, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CreateFailedHistory("Create history failed with history: " + history, e);
        }
        return history;
    }

    @Override
    public History updateById(int id, History history) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public List<History> findAll() {
        String query = "SELECT * FROM history";
        List<History> histories = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var history = new History();


                    // set time
                    Timestamp startTimeTimestamp = resultSet.getTimestamp("start_time");
                    Timestamp endTimeTimestamp = resultSet.getTimestamp("end_time");
                    // Convert Timestamp to LocalDateTime
                    LocalDateTime startTime = startTimeTimestamp.toLocalDateTime();
                    LocalDateTime endTime = endTimeTimestamp.toLocalDateTime();


                    history.setStartTime(startTime);
                    history.setEndTime(endTime);
                    history.setIdUser(resultSet.getInt("id_user"));
                    history.setIdHistory(resultSet.getInt("id_history"));
                    history.setIdResult(resultSet.getInt("id_result"));
                }
            }
        } catch (SQLException e) {
            throw new NotFoundHistory("Error finding all histories", e);
        }

        return histories;
    }


    @Override
    public History findById(int id) {
        String query = "SELECT * FROM history WHERE id_history = ?";

        History history = null;
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // set time
                    Timestamp startTimeTimestamp = resultSet.getTimestamp("start_time");
                    Timestamp endTimeTimestamp = resultSet.getTimestamp("end_time");
                    // Convert Timestamp to LocalDateTime
                    LocalDateTime startTime = startTimeTimestamp.toLocalDateTime();
                    LocalDateTime endTime = endTimeTimestamp.toLocalDateTime();


                    history.setStartTime(startTime);
                    history.setEndTime(endTime);
                    history.setIdUser(resultSet.getInt("id_user"));
                    history.setIdHistory(resultSet.getInt("id_history"));
                    history.setIdResult(resultSet.getInt("id_result"));
                }
            }
        } catch (SQLException e) {
            throw new NotFoundHistory("Error finding history by id with history's id: " + id, e);
        }

        return history;
    }
}
