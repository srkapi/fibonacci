package com.srkapi.base.application.fibonacci.values;

import lombok.Getter;

@Getter
public class FibonacciOutput {
  private Integer result;

  public FibonacciOutput(int result) {
    this.result = result;
  }
}
