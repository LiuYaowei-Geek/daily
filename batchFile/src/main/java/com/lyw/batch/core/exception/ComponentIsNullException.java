package com.lyw.batch.core.exception;

public class ComponentIsNullException extends Exception {
    private String code;
    private String message;

    public ComponentIsNullException(String message) {
        super(message);
        this.message = code;
    }

    public ComponentIsNullException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
