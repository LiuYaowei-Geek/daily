package com.lyw.batch.core.exception;

public class StepExecuteException extends Exception {
    private String code;
    private String message;

    public StepExecuteException(Throwable cause) {
        super(cause);
    }

    public StepExecuteException(String message) {
        super(message);
        this.message = message;
    }

    public StepExecuteException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
