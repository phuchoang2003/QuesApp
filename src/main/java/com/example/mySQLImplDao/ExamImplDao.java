package com.example.mySQLImplDao;

import com.example.DataSource.ConnectionPool;
import com.example.ExceptionHandling.DuplicateUserException;
import com.example.dao.ExamDao;
import com.example.dao.SubjectDao;
import com.example.entity.Exam;
import com.example.entity.Question;
import com.example.entity.Result;
import com.example.entity.Subject;
import com.example.utility.Helper;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class ExamImplDao implements ExamDao {


    @Override
    public boolean deleteAllExamByIdSubject(int idSubject) {
        String query = "DELETE FROM exams WHERE id_subject = ?";
        try(Connection connection = ConnectionPool.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,idSubject);
            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected > 0) return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Delete Exam failed", e);
        }
        return false;    }

    @Override
    public List<Exam> findAllExamSubmitted(List<Result> listResults) {
        // SELECT * FROM results WHERE id_result IN (?, ? , ? , v.v)
        String query = "SELECT * FROM exams WHERE id_exam" + Helper.supportINClause(listResults);
        List<Exam> exams = new ArrayList<>();

        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (int i = 0; i < listResults.size(); i++) {
                preparedStatement.setInt(i + 1, listResults.get(i).getIdExam());
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int idExam = resultSet.getInt("id_exam");
                    int idSubject = resultSet.getInt("id_subject");
                    String nameExam = resultSet.getString("name_exam");
                    int timeLimit = resultSet.getInt("time_limit");
                    var exam = new Exam(idExam,nameExam,timeLimit,idSubject);
                    exams.add(exam);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding exams corresponding to results due to a database error", e);
        }

        return exams;
    }

    @Override
    public List<Exam> findAllExamOfUser(int idUser) {
        String query = "SELECT * FROM exams INNER JOIN subjects ON exams.id_subject = subjects.id_subject INNER JOIN users ON subject.id_user = users.id_user WHERE users.id_user = ?";
        List<Exam> exams = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idUser);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var exam = new Exam();
                    exam.setNameExam(resultSet.getString("name_exam"));
                    exam.setTimeLimit(resultSet.getInt("time_limit"));
                    exam.setIdSubject(resultSet.getInt("id_subject"));
                    exam.setIdExam(resultSet.getInt("id_exam"));
                    exams.add(exam);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error finding exams by id user due to a database error", e);
        }

        return exams;
    }

    @Override
    public List<Exam> findAllExamOfSubject(int idSubject) {
        String query = "SELECT * FROM exams WHERE id_subject = ?";
        List<Exam> exams = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idSubject);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var exam = new Exam();
                    exam.setNameExam(resultSet.getString("name_exam"));
                    exam.setTimeLimit(resultSet.getInt("time_limit"));
                    exam.setIdSubject(resultSet.getInt("id_subject"));
                    exam.setIdExam(resultSet.getInt("id_exam"));
                    exams.add(exam);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error finding exams by id subject due to a database error", e);
        }

        return exams;
    }



    @Override
    public Exam create(Exam exam) throws DuplicateUserException {
        String query = "INSERT INTO exams (id_subject, name_exam, time_limit) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, exam.getIdSubject());
            preparedStatement.setString(2, exam.getNameExam());
            preparedStatement.setInt(3, exam.getTimeLimit());
            preparedStatement.executeUpdate();


            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    // 1 is the column index of the generated key
                    exam.setIdExam(resultSet.getInt(1));
                } else {
                    throw new SQLException("Creating exam, no ID obtained.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Create exam failed due to a database error", e);
        }
        return exam;
    }

    @Override
    public Exam updateById(int id, Exam exam) {
        return null;
    }

    @Override
    public boolean deleteById(int idExam) {
        String query = "DELETE FROM exams WHERE id_exam = ?";
        try(Connection connection = ConnectionPool.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,idExam);
            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected > 0) return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Delete Exam failed", e);
        }
        return false;
    }

    @Override
    public List<Exam> findAll() {
        String query = "SELECT * FROM exams";
        List<Exam> exams = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var exam = new Exam();
                    exam.setNameExam(resultSet.getString("name_exam"));
                    exam.setTimeLimit(resultSet.getInt("time_limit"));
                    exam.setIdSubject(resultSet.getInt("id_subject"));
                    exam.setIdExam(resultSet.getInt("id_exam"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error finding all exams due to a database error", e);
        }

        return exams;
    }

    @Override
    public Exam findById(int id) {
        String query = "SELECT * FROM exams WHERE id_exam = ?";
        Exam exam = null;
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    exam = new Exam();
                    exam.setNameExam(resultSet.getString("name_exam"));
                    exam.setTimeLimit(resultSet.getInt("time_limit"));
                    exam.setIdSubject(resultSet.getInt("id_subject"));
                    exam.setIdExam(id);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error finding exam by id due to a database error", e);
        }

        return exam;
    }
}
