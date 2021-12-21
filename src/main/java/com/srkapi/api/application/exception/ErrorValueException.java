package com.srkapi.api.application.exception;

import com.srkapi.api.shared.DomainException;
import com.srkapi.api.shared.Errors;
import lombok.Getter;

@Getter
public class ErrorValueException extends DomainException {

    public ErrorValueException(String msg) {
        this.code = Errors.CONFLICT;
        this.detail = msg;
    }
}
