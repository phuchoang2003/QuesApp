package com.example.CustomExceptionHandling;

public class NotFoundAnswer extends RuntimeException{
    public NotFoundAnswer(String message) {
        super(message);
    }

    public NotFoundAnswer(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundAnswer(Throwable cause) {
        super(cause);
    }
}
