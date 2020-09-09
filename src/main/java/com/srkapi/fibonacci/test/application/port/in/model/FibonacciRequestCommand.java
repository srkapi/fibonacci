package com.srkapi.fibonacci.test.application.port.in.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FibonacciRequestCommand implements Serializable {
    private Integer num;
}
