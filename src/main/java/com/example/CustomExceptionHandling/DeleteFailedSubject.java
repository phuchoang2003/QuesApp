package com.example.CustomExceptionHandling;

public class DeleteFailedSubject extends RuntimeException{

    public DeleteFailedSubject(String message) {
        super(message);
    }

    public DeleteFailedSubject(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteFailedSubject(Throwable cause) {
        super(cause);
    }
}
