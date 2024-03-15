package com.example.CustomExceptionHandling;


public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String message, Throwable cause) {
        super(message, cause);
    }


}
