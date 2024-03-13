package com.example.CustomExceptionHandling;

public class NotFoundResult extends RuntimeException{
    public NotFoundResult(String message) {
        super(message);
    }

    public NotFoundResult(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundResult(Throwable cause) {
        super(cause);
    }
}
