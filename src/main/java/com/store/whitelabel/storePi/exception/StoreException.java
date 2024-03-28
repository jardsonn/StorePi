package com.store.whitelabel.storePi.exception;

public class StoreException extends RuntimeException {
    private final ErrorCode errorCode;

    public StoreException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}