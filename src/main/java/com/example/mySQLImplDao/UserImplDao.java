package com.example.mySQLImplDao;

import com.example.DataSource.ConnectionPool;
import com.example.ExceptionHandling.DuplicateUserException;
import com.example.dao.UserDao;
import com.example.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserImplDao implements UserDao {
    @Override
    public User updateById(int id, User user) {
        return null;
    }

    @Override
    public User findById(int id) {
        String query = "SELECT * FROM users WHERE id_user = ?";
        User user = null;
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
             preparedStatement.setInt(1,id);
             ResultSet resultSet = preparedStatement.executeQuery();

             if (resultSet.next()) {
                 user = new User();
                 user.setPassword(resultSet.getString("password"));
                 user.setEmail(resultSet.getString("email"));
                 user.setUserName(resultSet.getString("userName"));
                }
            }
         catch (SQLException e) {
            throw new RuntimeException("Error fetching users", e);
        }

        return user;
    }

    @Override
    public User create(User user) throws DuplicateUserException {
        String query = "INSERT INTO users (email, password, user_name) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new DuplicateUserException("Duplicate key error. This user already exists.", e);
        } catch (SQLException e) {
            throw new RuntimeException("Registration failed due to a database error", e);
        }
        return user;
    }


    @Override
    public boolean deleteById(int id) {
        String query = "DELETE FROM users WHERE id_user = ?";

        return true;
    }

    @Override
    public List<User> findAll() {
        String query = "SELECT * FROM users";
        List<User> userList = new ArrayList<>();

        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setUserName(resultSet.getString("userName"));

                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching users", e);
        }

        return userList;
    }



    @Override
    public User findUserByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();
                    user.setPassword(resultSet.getString("password"));
                    user.setEmail(resultSet.getString("email"));
                    user.setId_user(resultSet.getInt("id_user"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}





