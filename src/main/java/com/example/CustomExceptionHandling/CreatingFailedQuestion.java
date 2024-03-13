package com.example.CustomExceptionHandling;

public class CreatingFailedQuestion extends RuntimeException{
    public CreatingFailedQuestion(String message) {
        super(message);
    }

    public CreatingFailedQuestion(String message, Throwable cause) {
        super(message, cause);
    }

    public CreatingFailedQuestion(Throwable cause) {
        super(cause);
    }
}
