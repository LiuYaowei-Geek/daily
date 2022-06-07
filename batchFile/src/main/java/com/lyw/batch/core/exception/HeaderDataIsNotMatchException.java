package com.lyw.batch.core.exception;

public class HeaderDataIsNotMatchException extends Exception {
    private String code;
    private String message;

    public HeaderDataIsNotMatchException(String message) {
        super(message);
        this.message = message;
    }

    public HeaderDataIsNotMatchException(String message, String code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }
}
