package com.example.CustomExceptionHandling;

public class CreatingFailedUser extends RuntimeException{
    public CreatingFailedUser(String message) {
        super(message);
    }

    public CreatingFailedUser(String message, Throwable cause) {
        super(message, cause);
    }

    public CreatingFailedUser(Throwable cause) {
        super(cause);
    }
}
