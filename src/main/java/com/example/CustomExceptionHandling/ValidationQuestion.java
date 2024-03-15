package com.example.CustomExceptionHandling;

public class ValidationQuestion extends RuntimeException{
    public ValidationQuestion(String message) {
        super(message);
    }

    public ValidationQuestion(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationQuestion(Throwable cause) {
        super(cause);
    }
}
