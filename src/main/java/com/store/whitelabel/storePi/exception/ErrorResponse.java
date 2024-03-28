package com.store.whitelabel.storePi.exception;

public record ErrorResponse(ErrorCode errorCode, String errorMessage) {
}
