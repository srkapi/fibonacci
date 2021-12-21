package com.srkapi.api.application.port.in.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
public class FibonacciResponse {
    private Integer result;

    public FibonacciResponse(int result) {
        this.result=result;
    }
}
