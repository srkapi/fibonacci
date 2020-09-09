package com.srkapi.fibonacci.test.application.port.in.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage implements Serializable {
    private String message;
    private int code;

}
