package com.example.CustomExceptionHandling;

public class DeleteFailedHistory extends RuntimeException{
    public DeleteFailedHistory(String message) {
        super(message);
    }

    public DeleteFailedHistory(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteFailedHistory(Throwable cause) {
        super(cause);
    }
}
