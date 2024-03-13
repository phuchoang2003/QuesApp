package com.example.CustomExceptionHandling;

public class NotFoundHistory extends RuntimeException{
    public NotFoundHistory(String message) {
        super(message);
    }

    public NotFoundHistory(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundHistory(Throwable cause) {
        super(cause);
    }
}
