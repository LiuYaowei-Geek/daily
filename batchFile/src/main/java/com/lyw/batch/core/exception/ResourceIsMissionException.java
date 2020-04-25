package com.lyw.batch.core.exception;

public class ResourceIsMissionException extends Exception {
    private String code;
    private String message;

    public ResourceIsMissionException(String message) {
        super(message);
        this.message = message;
    }

    public ResourceIsMissionException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
