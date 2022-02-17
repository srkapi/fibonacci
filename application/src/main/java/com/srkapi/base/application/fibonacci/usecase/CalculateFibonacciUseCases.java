package com.srkapi.base.application.fibonacci.usecase;

import com.srkapi.base.application.fibonacci.values.FibonacciInput;
import com.srkapi.base.application.fibonacci.values.FibonacciOutput;
import com.srkapi.base.shared.domain.UseCase;

public interface CalculateFibonacciUseCases extends UseCase<FibonacciOutput, FibonacciInput> {}
