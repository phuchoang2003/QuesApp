package com.example.CustomExceptionHandling;

public class DeleteQuestionFailed extends RuntimeException{
    public DeleteQuestionFailed(String message) {
        super(message);
    }

    public DeleteQuestionFailed(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteQuestionFailed(Throwable cause) {
        super(cause);
    }
}
