package com.srkapi.api.shared;

import lombok.Getter;

@Getter
public abstract class DomainException extends Exception {
    protected Errors code;
    protected String detail;
}
