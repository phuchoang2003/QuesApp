package com.example.CustomExceptionHandling;

public class DeleteFailedExam extends  RuntimeException{
    public DeleteFailedExam(String message) {
        super(message);
    }

    public DeleteFailedExam(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteFailedExam(Throwable cause) {
        super(cause);
    }
}
