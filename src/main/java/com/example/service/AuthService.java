package com.example.service;

import com.example.CustomExceptionHandling.DuplicateUserException;
import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.utility.Encryption;

import java.sql.SQLIntegrityConstraintViolationException;

public class AuthService {
    private final UserDao userDao;

    public AuthService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void register(User user) throws DuplicateUserException {
        try {
            // Encrypt password
            String encryptedPassword = Encryption.encryptPassword(user.getPassword());
            user.setPassword(encryptedPassword);

            // save user
            User userCurrent = userDao.create(user);
            if(userCurrent== null) throw new RuntimeException("Created user failed");

        } catch (DuplicateUserException e) {
            throw e;
        } catch (Exception e) {
            if (isDuplicateKeyException(e)) {
                throw new DuplicateUserException("Duplicate key error. This user already exists.", e);
            } else {
                throw new RuntimeException("Registration failed due to a database error", e);
            }
        }



    }
    private boolean checkUserPassword(User user, String password) {
        return user != null && Encryption.checkPassword(password, user.getPassword());
    }

    public int loginAndGetIdUser(String email, String password) {
        try {
            // Find user by email
            User user = userDao.findUserByEmail(email);

            // Check password
            if (user != null && checkUserPassword(user, password)) {
                // if login successful return id user
                return user.getId_user();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }



    private boolean isDuplicateKeyException(Exception e) {
        return e instanceof SQLIntegrityConstraintViolationException &&
                e.getMessage() != null && e.getMessage().contains("Duplicate entry");
    }




}
