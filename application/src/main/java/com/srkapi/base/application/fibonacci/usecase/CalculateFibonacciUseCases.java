package com.srkapi.base.application.fibonacci.usecase;

import com.srkapi.base.application.fibonacci.values.FibonacciInput;
import com.srkapi.base.application.fibonacci.values.FibonacciOutput;
import com.srkapi.base.shared.domain.UseCases;

public interface CalculateFibonacciUseCases extends UseCases<FibonacciOutput, FibonacciInput> {
}
