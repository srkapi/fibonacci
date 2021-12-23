package com.srkapi.base.domain.fibonacci.domain.exceptions;

import com.srkapi.base.shared.DomainException;
import com.srkapi.base.shared.Errors;

public class NumberErrorException extends DomainException {

    public NumberErrorException(String msg) {
        this.code = Errors.CONFLICT;
        this.detail = msg;
    }
}
