package com.example.CustomExceptionHandling;

public class NotFoundUser extends RuntimeException{

    public NotFoundUser(String message) {
        super(message);
    }

    public NotFoundUser(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundUser(Throwable cause) {
        super(cause);
    }
}
