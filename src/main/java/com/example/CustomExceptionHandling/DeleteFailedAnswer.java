package com.example.CustomExceptionHandling;

public class DeleteFailedAnswer extends RuntimeException{
    public DeleteFailedAnswer(String message) {
        super(message);
    }

    public DeleteFailedAnswer(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteFailedAnswer(Throwable cause) {
        super(cause);
    }
}
