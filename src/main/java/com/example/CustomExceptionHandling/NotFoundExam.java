package com.example.CustomExceptionHandling;

public class NotFoundExam extends RuntimeException{
    public NotFoundExam(String message) {
        super(message);
    }

    public NotFoundExam(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundExam(Throwable cause) {
        super(cause);
    }
}
