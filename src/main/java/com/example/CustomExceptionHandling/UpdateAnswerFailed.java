package com.example.CustomExceptionHandling;

public class UpdateAnswerFailed extends RuntimeException{
    public UpdateAnswerFailed(String message) {
        super(message);
    }

    public UpdateAnswerFailed(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateAnswerFailed(Throwable cause) {
        super(cause);
    }
}
