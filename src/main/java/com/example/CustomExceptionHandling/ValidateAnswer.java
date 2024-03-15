package com.example.CustomExceptionHandling;

public class ValidateAnswer extends RuntimeException{
    public ValidateAnswer(String message) {
        super(message);
    }

    public ValidateAnswer(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateAnswer(Throwable cause) {
        super(cause);
    }
}
