package com.example.dao;

import com.example.CustomExceptionHandling.DuplicateUserException;

import java.util.List;

public interface Dao<T> {

    T create(T T) ;
    T updateById(int id,T t);
    boolean deleteById(int id);
    List<T> findAll();

    T findById(int id);
}
