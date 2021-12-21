package com.srkapi.api.fibonacci.application.command;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class FibonacciCommand {
    @NonNull
    private Integer num;

    public FibonacciCommand(Integer num) {
        this.num = num;
    }
}
