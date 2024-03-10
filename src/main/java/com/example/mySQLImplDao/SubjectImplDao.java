package com.example.mySQLImplDao;

import com.example.DataSource.ConnectionPool;
import com.example.dao.SubjectDao;
import com.example.entity.Exam;
import com.example.entity.Subject;
import com.example.utility.Helper;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class SubjectImplDao implements SubjectDao {


    @Override
    public List<Subject> findAllSubjectFromExam(List<Exam> listExam) {
        String query = "SELECT * FROM subjects WHERE id_subject" + Helper.supportINClause(listExam);
        List<Subject> subjects = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (int i = 0; i < listExam.size(); i++) {
                preparedStatement.setInt(i + 1, listExam.get(i).getIdExam());
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int idSubject = resultSet.getInt("id_subject");
                    String nameSubject = resultSet.getString("name_subject");
                    int idUser = resultSet.getInt("id_user");
                    var subject = new Subject(nameSubject,idSubject,idUser);
                    subjects.add(subject);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding subjects corresponding to exam due to a database error", e);
        }

        return subjects;
    }

    @Override
    public List<Subject> findAllSubjetsOfUser(int idUser) {
        String query = "SELECT * FROM subjects WHERE id_user = ?";
        List<Subject> subjects = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idUser);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var subject = new Subject();
                    subject.setId(resultSet.getInt("id_subject"));
                    subject.setNameSubject(resultSet.getString("name_subject"));
                    subject.setIdUser(resultSet.getInt("id_user"));
                    subjects.add(subject);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error finding subjects by id user due to a database error", e);
        }

        return subjects;
    }
    @Override
    public Subject create(Subject subject) {
        String query = "INSERT INTO subjects (name_subject, id_user) VALUES (?, ?)";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, subject.getNameSubject());
            preparedStatement.setInt(2, subject.getIdUser());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating subject failed, no rows affected.");
            }

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    // 1 is the id column of subjects table
                    subject.setId(resultSet.getInt(1));
                } else {
                    throw new SQLException("Creating subject failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating subject due to a database error", e);
        }
        return subject;
    }


    @Override
    public Subject findById(int id) {
        String query = "SELECT * FROM subjects WHERE id_subject = ?";
        Subject subject = new Subject();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    subject.setId(resultSet.getInt("id_subject"));
                    subject.setNameSubject(resultSet.getString("name_subject"));
                    subject.setIdUser(resultSet.getInt("id_user"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error finding subject by id due to a database error", e);
        }

        return subject;
    }

    @Override
    public Subject updateById(int idOldSubject, Subject newSubject) {
        String query = "UPDATE subjects SET name_subject = ? WHERE id_subject = ?";
        String newSubjectName = newSubject.getNameSubject();
        var oldSubject = findById(idOldSubject);
        int idUser = oldSubject.getIdUser();

        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newSubjectName);
            preparedStatement.setInt(2, idOldSubject);


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return new Subject(newSubjectName,idOldSubject,idUser);
            }

        } catch (Exception e) {
            throw new RuntimeException("Update subject by id failed", e);
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "DELETE FROM subjects WHERE id_subject = ?";
        try(Connection connection = ConnectionPool.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);
            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected > 0) return true;
        }
        catch (Exception e) {
            throw new RuntimeException("Delete subject failed", e);
        }
        return false;
    }

    @Override
    public List<Subject> findAll() {
        String query = "SELECT * FROM subjects";
        List<Subject> subjects = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_subject");
                String name = resultSet.getString("name_subject");
                int idUser = resultSet.getInt("id_user");
                    var subject = new Subject(name,id,idUser);
                    subjects.add(subject);
                }
        }
         catch (Exception e) {
            throw new RuntimeException("Found all subjects failed due to a database error", e);
        }

        return subjects;
    }




    @Override
    public Subject findByName(String name, int userId) {
        String query = "SELECT * FROM subjects WHERE name_subject = ? AND id_user = ?";
        Subject subject = null;

        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    subject = new Subject();
                    subject.setId(resultSet.getInt("id_subject"));
                    subject.setNameSubject(resultSet.getString("name_subject"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error finding subject by name and user ID due to a database error", e);
        }

        return subject;
    }


}
