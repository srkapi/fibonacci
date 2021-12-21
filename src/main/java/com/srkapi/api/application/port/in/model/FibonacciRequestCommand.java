package com.srkapi.api.application.port.in.model;

import lombok.Getter;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Getter
public class FibonacciRequestCommand {
    @NonNull
    private Integer num;

    public FibonacciRequestCommand(Integer num) {
        this.num = num;
    }
}
