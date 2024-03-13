package com.example.CustomExceptionHandling;

public class UpdateFailedSubject extends RuntimeException {
    public UpdateFailedSubject(String message) {
        super(message);
    }

    public UpdateFailedSubject(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateFailedSubject(Throwable cause) {
        super(cause);
    }
}
