package com.example.CustomExceptionHandling;

public class UpdateFailedQuestion extends RuntimeException{
    public UpdateFailedQuestion(String message) {
        super(message);
    }

    public UpdateFailedQuestion(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateFailedQuestion(Throwable cause) {
        super(cause);
    }
}
