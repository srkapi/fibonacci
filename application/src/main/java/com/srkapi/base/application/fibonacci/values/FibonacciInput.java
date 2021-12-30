package com.srkapi.base.application.fibonacci.values;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class FibonacciInput {
    @NonNull
    private Integer num;

    public FibonacciInput(Integer num) {
        this.num = num;
    }
}
