package com.srkapi.fibonacci.test.application.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorValueException extends RuntimeException {

    private String msg;

    public ErrorValueException(String msg) {
        this.msg = msg;
    }
}
