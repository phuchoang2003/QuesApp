package com.example.CustomExceptionHandling;

public class NotFoundQuestion extends RuntimeException{
    public NotFoundQuestion(String message) {
        super(message);
    }

    public NotFoundQuestion(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundQuestion(Throwable cause) {
        super(cause);
    }
}
