package com.store.whitelabel.storePi.util;

import com.store.whitelabel.storePi.exception.ErrorCode;
import com.store.whitelabel.storePi.exception.StoreException;

import java.time.format.DateTimeParseException;
import java.util.Date;

public class ValidatorUtil {
    public static void validEmptyField(String value) throws StoreException {
        if (value == null || value.isBlank()) {
            throw new StoreException(ErrorCode.EMPTY_FIELD, "Este campo é obrigatório.");
        }
    }

    public static void validEmptyField(Integer value) throws StoreException {
        if (value == null) {
            throw new StoreException(ErrorCode.EMPTY_FIELD, "Este campo é obrigatório.");
        }
    }


    public static void validateDate(Date date) throws StoreException {
        try {
            Date currentDate = new Date();
            if (date.after(currentDate)) {
                throw new StoreException(ErrorCode.INVALID_DATE, "A data de lançamento não pode estar no futuro.");
            }

        } catch (DateTimeParseException e) {
            throw new StoreException(ErrorCode.INVALID_DATE, "Data de lançamento inválida.");
        }
    }
}
