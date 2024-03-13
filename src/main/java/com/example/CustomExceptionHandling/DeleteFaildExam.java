package com.example.CustomExceptionHandling;

public class DeleteFaildExam extends  RuntimeException{
    public DeleteFaildExam(String message) {
        super(message);
    }

    public DeleteFaildExam(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteFaildExam(Throwable cause) {
        super(cause);
    }
}
