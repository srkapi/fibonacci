package com.srkapi.api.web.controller.request;

import lombok.*;

import java.io.Serializable;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorRequest  {
    private Integer number;
}
