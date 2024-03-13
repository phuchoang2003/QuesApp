package com.example.CustomExceptionHandling;

public class CreateFailedHistory extends RuntimeException{
    public CreateFailedHistory(String message) {
        super(message);
    }

    public CreateFailedHistory(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateFailedHistory(Throwable cause) {
        super(cause);
    }
}
