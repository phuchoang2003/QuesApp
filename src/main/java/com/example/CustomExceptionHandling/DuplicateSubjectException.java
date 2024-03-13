package com.example.CustomExceptionHandling;

public class DuplicateSubjectException extends RuntimeException {
    public DuplicateSubjectException(String message) {
        super(message);
    }
}
