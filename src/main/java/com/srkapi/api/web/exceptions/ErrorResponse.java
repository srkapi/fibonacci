package com.srkapi.api.web.exceptions;

import lombok.Builder;

import java.util.List;

@Builder
public class ErrorResponse {
    private String message;
    private List<String> errors;

    public ErrorResponse(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return this.message;
    }

    public List<String> getErrors() {
        return this.errors;
    }

}
