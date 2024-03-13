package com.example.CustomExceptionHandling;

public class DeleteFailedResult extends RuntimeException{
    public DeleteFailedResult(String message) {
        super(message);
    }

    public DeleteFailedResult(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteFailedResult(Throwable cause) {
        super(cause);
    }
}
