package com.example.mySQLImplDao;

import com.example.CustomExceptionHandling.*;
import com.example.DataSource.ConnectionPool;
import com.example.dao.AnswerDao;
import com.example.entity.Answer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnswerimplDao implements AnswerDao {
    @Override
    public Answer create(Answer answer) {
        String query = "INSERT INTO answers (content, is_correct, id_question) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, answer.getContentOption());
            preparedStatement.setBoolean(2, answer.isCorrect());
            preparedStatement.setInt(3, answer.getIdQuestion());
            preparedStatement.executeUpdate();


            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    // 1 is the column index of the generated key
                    answer.setIdAnswer(resultSet.getInt(1));
                } else {
                    throw new SQLException("Creating answer failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CreatingAnswerFailed("Create answer failed with answer: " + answer.toString(), e);
        }
        return answer;
    }



    @Override
    public List<Answer> findAllAnswerByQuestion(int idQuestion) {
        String query = "SELECT * FROM answers WHERE id_question = ?";
        List<Answer> result = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idQuestion);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int idAnswer = resultSet.getInt("id_answer");
                    String content = resultSet.getString("content");
                    boolean isCorrect = resultSet.getBoolean("is_correct");
                    var answer = new Answer(idAnswer,content,isCorrect,idQuestion);
                    result.add(answer);
                }
            }
        } catch (SQLException e) {
            throw new NotFoundAnswer("Error finding answers by question with question's id: " + idQuestion, e);
        }

        return result;

    }

    @Override
    public Answer updateById(int idOldAnswer, Answer newAnswer) {
        String query = "UPDATE answers SET content = ?, is_correct = ? WHERE id_answer = ?";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
             String newContent = newAnswer.getContentOption();
             boolean newIsCorrect = newAnswer.isCorrect();

             // get id question of answer
             Answer oldAnswer = findById(idOldAnswer);
             if(oldAnswer!= null){
                 int idQuestion = oldAnswer.getIdQuestion();
                 preparedStatement.setString(1,newContent);
                 preparedStatement.setBoolean(2,newIsCorrect);
                 preparedStatement.setInt(3,idOldAnswer);

                 int rowsAffected = preparedStatement.executeUpdate();
                 if (rowsAffected > 0) return new Answer(idOldAnswer,newContent,newIsCorrect,idQuestion);
             }
             else throw new NotFoundAnswer("Error finding answer by question with answer's id: " + idOldAnswer);
        } catch (NotFoundExam e) {
            throw new NotFoundAnswer(e.getMessage(),e);
        }
        catch (SQLException e){
            throw new UpdateAnswerFailed("Update answer failed with answer: " + newAnswer + " with answer's id: " + idOldAnswer,e);
        }
        return null;

    }

    @Override
    public boolean deleteById(int idAnswer) {
        String query = "DELETE FROM answers WHERE id_answer = ?";
        try(Connection connection = ConnectionPool.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,idAnswer);
            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected > 0) return true;
        }
        catch (SQLException e) {
            throw new DeleteFailedAnswer("Delete answer failed with answer's id: " + idAnswer, e);
        }
        return false;
    }


    @Override
    public boolean deleteAllAnswerByQuestion(int idQuestion) {
        String query = "DELETE FROM answers WHERE id_question = ?";
        try(Connection connection = ConnectionPool.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,idQuestion);
            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected > 0) return true;
        }
        catch (SQLException e) {
            throw new DeleteFailedAnswer("Delete all answers by question with question's id: " + idQuestion + " failed", e);
        }
        return false;
    }

    @Override
    public List<Answer> findAll() {
        String query = "SELECT * FROM answers";
        List<Answer> answers = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var answer = new Answer();
                    answer.setIdAnswer(resultSet.getInt("id_answer"));
                    answer.setContentOption(resultSet.getString("content"));
                    answer.setCorrect(resultSet.getBoolean("is_correct"));
                    answer.setIdQuestion(resultSet.getInt("id_question"));
                }
            }
        } catch (SQLException e) {
            throw new NotFoundAnswer("Error finding all answers", e);
        }

        return answers;
    }


    @Override
    public Answer findById(int idAnswer) {
        String query = "SELECT * FROM answers WHERE id_answer = ?";
        Answer answer = null;
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idAnswer);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    answer = new Answer();
                    answer.setIdAnswer(resultSet.getInt("id_answer"));
                    answer.setContentOption(resultSet.getString("content"));
                    answer.setCorrect(resultSet.getBoolean("is_correct"));
                    answer.setIdQuestion(resultSet.getInt("id_question"));
                }
            }
        } catch (SQLException e) {
            throw new NotFoundAnswer("Error finding answer by id with answer's id: " + idAnswer, e);
        }

        return answer;
    }
}
