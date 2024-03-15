package com.example.mySQLImplDao;

import com.example.CustomExceptionHandling.*;
import com.example.DataSource.ConnectionPool;
import com.example.dao.QuestionDao;
import com.example.entity.Question;
import com.example.utility.Helper;

import java.security.cert.CertificateRevokedException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionImplDao implements QuestionDao {

    @Override
    public List<Question> findAlQuestionsByListId(List<Integer> listIds) {
        String query = "SELECT * FROM questions WHERE id_question" + Helper.supportINClause(listIds);

        List<Question> questions = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (int i = 0; i < listIds.size(); i++) {
                preparedStatement.setInt(i + 1, listIds.get(i));
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Question question = new Question();
                    question.setIdQuestion(resultSet.getInt("id_question"));
                    question.setContent(resultSet.getString("content"));
                    question.setIdSubject(resultSet.getInt("id_subject"));
                    questions.add(question);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new NotFoundQuestion("Error finding list questions with ids: " + listIds, e);
        }

        return questions;
    }


    @Override
    public List<Question> findAllQuestionOfExam(int idExam) {
        String query = "SELECT * FROM questions JOIN questions_exams ON questions.id_question = questions_exams.id_question WHERE questions_exams.id_exam = ?";
        List<Question> questions = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idExam);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Question question = new Question();
                    question.setIdQuestion(resultSet.getInt("id_question"));
                    question.setContent(resultSet.getString("content"));
                    question.setIdSubject(resultSet.getInt("id_subject"));
                    questions.add(question);
                }
            }
        } catch (SQLException e) {
            throw new NotFoundQuestion("Error finding questions of exam with Exam's id: " + idExam, e);
        }
        return questions;
    }


    @Override
    public void removeQuestionFromExam(int idQuestion, int idExam) {
        String query = "DELETE FROM questions_exams WHERE id_question = ? AND id_exam = ?";

        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idQuestion);
            statement.setInt(2, idExam);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DeleteQuestionFailed("Remove question with question's id: " + idQuestion + " from exam with exam's id: " + idExam +" failed", e);
        }
    }

    @Override
    public void addQuestionsToExam(List<Integer> idQuestions, int idExam) {
        String query = "INSERT INTO questions_exams (id_question, id_exam) VALUES (?, ?)";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            for (int idQuestion : idQuestions) {
                statement.setInt(1, idQuestion);
                statement.setInt(2, idExam);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            throw new AddQuestionsToExamFailed("Add questions with question's ids: " + idQuestions + " to exam with exam's id: " + idExam,e);
        }
    }



    @Override
    public List<Question> findAllQuestionBySubject(int idSubject) {
        String query = "SELECT * FROM questions WHERE id_subject = ?";
        List<Question> questions = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idSubject);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int idQuestion = resultSet.getInt("id_question");
                    String content = resultSet.getString("content");
                    var question = new Question(idQuestion,content,idSubject);
                    questions.add(question);
                }
            }
        } catch (SQLException e) {

            throw new NotFoundQuestion("Error finding question by subject with Subject's id: " + idSubject, e);
        }

        return questions;
    }

    @Override
    public Question create(Question question) {
        String query = "INSERT INTO questions (content, id_subject) VALUES (?, ?)";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, question.getContent());
            preparedStatement.setInt(2, question.getIdSubject());


            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating question failed, no rows affected.");
            }

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    // 1 is the column index of the generated key
                    question.setIdQuestion(resultSet.getInt(1));
                } else {
                    throw new SQLException("Creating question failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new CreatingFailedQuestion("Create question failed with question: " + question.toString(), e);
        }
        return question;
    }



    @Override
    public Question findById(int id) {
        String query = "SELECT * FROM questions WHERE id_question = ?";
        Question question = null;
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    question = new Question();
                    question.setIdQuestion(resultSet.getInt("id_question"));
                    question.setContent(resultSet.getString("content"));
                    question.setIdSubject(resultSet.getInt("id_subject"));
                }
            }
        } catch (SQLException e) {
            throw new NotFoundQuestion("Error finding question by id with question's id: " + id, e);
        }

        return question;
    }

    @Override
    public Question updateById(int idOldQuestion, Question newQuestion) {
        String query = "UPDATE questions SET content = ? WHERE id_question = ?";
        String newQuestionContent= newQuestion.getContent();

        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(query)) {

            prepareStatement.setString(1, newQuestionContent);
            prepareStatement.setInt(2, idOldQuestion);

            int rowsAffected = prepareStatement.executeUpdate();

            Question question = findById(idOldQuestion);
            int idSubject = question.getIdSubject();

            if (rowsAffected > 0) {
                return new Question(idOldQuestion,newQuestionContent,idSubject);
            }

        } catch (Exception e) {
            throw new UpdateFailedQuestion("Update failed question: " + newQuestion + " with question's id: " + idOldQuestion,e);
        }
        return null;
    }

    @Override
    public boolean deleteById(int idQuestion) {
        String query = "DELETE FROM questions WHERE id_question = ?";
        try(Connection connection = ConnectionPool.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,idQuestion);
            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected > 0) return true;
        }
        catch (SQLException e) {
            throw new DeleteQuestionFailed("Delete question failed with question's id: " + idQuestion, e);
        }
        return false;
    }

    @Override
    public List<Question> findAll() {
        String query = "SELECT * FROM questions";
        List<Question> questions = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idQuestion = resultSet.getInt("id_question");
                int idSubject = resultSet.getInt("id_subject");
                String content = resultSet.getString("content");
                var question = new Question(idQuestion,content,idSubject);
                questions.add(question);
            }
        }
        catch (SQLException e) {
            throw new NotFoundQuestion("Found all questions failed", e);
        }

        return questions;
    }
}
