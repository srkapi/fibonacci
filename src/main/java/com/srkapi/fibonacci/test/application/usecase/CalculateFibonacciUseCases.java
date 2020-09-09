package com.srkapi.fibonacci.test.application.usecase;

import com.srkapi.fibonacci.test.application.port.in.model.FibonacciRequestCommand;
import com.srkapi.fibonacci.test.application.port.in.model.FibonacciResponse;

public interface CalculateFibonacciUseCases {

    FibonacciResponse process(FibonacciRequestCommand fibonacciRequestCommand);

}
