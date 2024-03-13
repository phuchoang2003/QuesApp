package com.example.CustomExceptionHandling;

public class CreatingFailedSubject extends RuntimeException{

    public CreatingFailedSubject(String message) {
        super(message);
    }

    public CreatingFailedSubject(String message, Throwable cause) {
        super(message, cause);
    }

    public CreatingFailedSubject(Throwable cause) {
        super(cause);
    }
}
