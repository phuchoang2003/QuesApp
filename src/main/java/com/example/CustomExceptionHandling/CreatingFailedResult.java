package com.example.CustomExceptionHandling;

public class CreatingFailedResult extends RuntimeException{
    public CreatingFailedResult(String message) {
        super(message);
    }

    public CreatingFailedResult(String message, Throwable cause) {
        super(message, cause);
    }

    public CreatingFailedResult(Throwable cause) {
        super(cause);
    }
}
