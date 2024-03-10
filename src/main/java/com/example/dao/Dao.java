package com.example.dao;

import com.example.ExceptionHandling.DuplicateUserException;

import java.util.List;

public interface Dao<T> {

    T create(T T) throws DuplicateUserException;
    T updateById(int id,T t);
    boolean deleteById(int id);
    List<T> findAll();

    T findById(int id);
}
