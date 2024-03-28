package com.store.whitelabel.storePi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StoreException.class)
    public ResponseEntity<ErrorResponse> handleStoreException(StoreException ex) {
        ErrorCode errorCode = ex.getErrorCode();
        String errorMessage = ex.getMessage();

        HttpStatus httpStatus = switch (errorCode) {
            case PRODUCT_NOT_FOUND -> HttpStatus.NOT_FOUND;
            case INVALID_CATEGORY_ID,
                    INVALID_BRAND_ID,
                    INVALID_PRICE,
                    INVALID_STOCK,
                    INVALID_BRAND_NAME,
                    INVALID_CATEGORY_NAME,
                    INVALID_DATE,
                    EMPTY_FIELD -> HttpStatus.BAD_REQUEST;
        };

        ErrorResponse errorResponse = new ErrorResponse(errorCode, errorMessage);
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

}

