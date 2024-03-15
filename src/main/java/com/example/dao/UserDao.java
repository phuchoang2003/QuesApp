package com.example.dao;


import com.example.CustomExceptionHandling.DuplicateUserException;
import com.example.entity.User;

public interface UserDao extends Dao<User> {


    User findUserByEmail(String email);
}
