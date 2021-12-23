package com.srkapi.base.application.fibonacci.command;

import lombok.Getter;

@Getter
public class FibonacciCommandResult {
    private Integer result;

    public FibonacciCommandResult(int result) {
        this.result=result;
    }
}
