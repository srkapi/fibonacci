package com.srkapi.api.domain.fibonacci.domain.exceptions;

import com.srkapi.api.shared.DomainException;
import com.srkapi.api.shared.Errors;

public class NumberErrorException extends DomainException {

    public NumberErrorException(String msg) {
        this.code = Errors.CONFLICT;
        this.detail = msg;
    }
}
