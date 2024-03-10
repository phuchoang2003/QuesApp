package com.example.mySQLImplDao;

import com.example.DataSource.ConnectionPool;
import com.example.ExceptionHandling.DuplicateUserException;
import com.example.dao.ResultDao;
import com.example.entity.History;
import com.example.entity.Result;
import com.example.utility.Helper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultImplDao implements ResultDao {

    @Override
    public List<Result> findAllResultOfExam(int idExam) {
        String query = "SELECT * FROM results WHERE id_exam = ?";
        List<Result> results = new ArrayList<>();

        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int idResult = resultSet.getInt("id_result");
                    double score = resultSet.getDouble("score");
                    var result = new Result(idResult, idExam, score);
                    results.add(result);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding results corresponding to histories due to a database error", e);
        }

        return results;
    }

    @Override
    public boolean deleteResultsByExamId(int idExam) {
        String query = "DELETE FROM exams WHERE id_exam = ?";
        try(Connection connection = ConnectionPool.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,idExam);
            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected > 0) return true;
        }
        catch (Exception e) {
            throw new RuntimeException("Delete results failed", e);
        }
        return false;
    }

    @Override
    public List<Result> findAllResultCorrespondingHistory(List<History> histories) {
        // SELECT * FROM results WHERE id_result IN (?, ? , ? , v.v)
        String query = "SELECT * FROM results WHERE id_result" + Helper.supportINClause(histories);

        List<Result> results = new ArrayList<>();

        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (int i = 0; i < histories.size(); i++) {
                preparedStatement.setInt(i + 1, histories.get(i).getIdResult());
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int idResult = resultSet.getInt("id_result");
                    int idExam = resultSet.getInt("id_exam");
                    double score = resultSet.getDouble("score");
                    var result = new Result(idResult, idExam, score);
                    results.add(result);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding results corresponding to histories due to a database error", e);
        }

        return results;
    }



    @Override
    public Result create(Result result) throws DuplicateUserException {
        String query = "INSERT INTO results (id_exam, score) VALUES (?, ?)";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, result.getIdExam());
            preparedStatement.setDouble(2, result.getScore());
            preparedStatement.executeUpdate();


            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    // 1 is the column index of the generated key
                    result.setIdResult(resultSet.getInt(1));
                } else {
                    throw new SQLException("Creating result, no ID obtained.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Create result failed due to a database error", e);
        }
        return result;
    }

    @Override
    public Result updateById(int id, Result result) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public List<Result> findAll() {
        String query = "SELECT * FROM results";
        List<Result> results = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idResult = resultSet.getInt("id_result");
                int idExam = resultSet.getInt("id_exam");
                double score = resultSet.getDouble("score");
                var result = new Result(idResult, idExam, score);
                results.add(result);
                }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding all results due to a database error", e);
        }

        return results;
     }

    @Override
    public Result findById(int id) {
        String query = "SELECT * FROM results WHERE id_result = ?";
        Result result = null;
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int idResult = resultSet.getInt("id_result");
                int idExam = resultSet.getInt("id_exam");
                double score = resultSet.getDouble("score");
                result = new Result(idResult, idExam, score);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding result by id due to a database error", e);
        }

        return result;
    }
}
