package com.example.CustomExceptionHandling;

import java.sql.SQLException;

public class DuplicateUserException extends SQLException {
    public DuplicateUserException(String message, Throwable cause) {
        super(message, cause);
    }


}
