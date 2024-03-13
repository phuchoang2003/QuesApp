package com.example.CustomExceptionHandling;


public class NotFoundSubject extends RuntimeException {
    public NotFoundSubject(String message, Throwable cause) {
        super(message,cause);
    }

    public NotFoundSubject(String message) {
        super(message);
    }

    public NotFoundSubject(Throwable cause) {
        super(cause);
    }
}
