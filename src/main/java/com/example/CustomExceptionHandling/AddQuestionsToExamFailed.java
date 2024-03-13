package com.example.CustomExceptionHandling;

public class AddQuestionsToExamFailed extends RuntimeException {
    public AddQuestionsToExamFailed(String message) {
        super(message);
    }

    public AddQuestionsToExamFailed(String message, Throwable cause) {
        super(message, cause);
    }

    public AddQuestionsToExamFailed(Throwable cause) {
        super(cause);
    }
}
