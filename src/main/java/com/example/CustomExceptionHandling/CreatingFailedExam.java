package com.example.CustomExceptionHandling;

public class CreatingFailedExam extends RuntimeException{
    public CreatingFailedExam(String message) {
        super(message);
    }

    public CreatingFailedExam(String message, Throwable cause) {
        super(message, cause);
    }

    public CreatingFailedExam(Throwable cause) {
        super(cause);
    }
}
