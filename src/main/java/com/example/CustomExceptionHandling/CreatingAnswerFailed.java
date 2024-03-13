package com.example.CustomExceptionHandling;

public class CreatingAnswerFailed extends RuntimeException{
    public CreatingAnswerFailed(String message) {
        super(message);
    }

    public CreatingAnswerFailed(String message, Throwable cause) {
        super(message, cause);
    }

    public CreatingAnswerFailed(Throwable cause) {
        super(cause);
    }
}
