package com.srkapi.base.shared.domain;

import lombok.Getter;

@Getter
public abstract class DomainException extends Exception {
    protected Errors code;
    protected String detail;
}
