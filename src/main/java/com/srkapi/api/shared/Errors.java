package com.srkapi.api.shared;

import lombok.Getter;

@Getter
public enum Errors {
    NOT_FOUND("resource not found"),
    UNAUTHORIZED("unauthorized"),
    INVALID("invalid parameter"),
    CONFLICT("domain conflict"),
    INTERNAL_ERROR("internal server error");


    private String detail;

    Errors(String value) {
        this.detail = value;
    }
}
