package com.srkapi.base.application.fibonacci;

import com.srkapi.base.application.fibonacci.values.FibonacciInput;
import com.srkapi.base.application.fibonacci.values.FibonacciOutput;
import com.srkapi.base.application.fibonacci.usecase.CalculateFibonacciUseCases;
import com.srkapi.base.domain.fibonacci.domain.exceptions.NumberErrorException;
import com.srkapi.base.shared.DomainException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FibonacciCalculator implements CalculateFibonacciUseCases {

    @Override
    public FibonacciOutput execute(FibonacciInput fibonacciRequestCommand) throws DomainException {
        if (fibonacciRequestCommand.getNum() <= 0) throw new NumberErrorException("value is negative");
        int result = calculate(fibonacciRequestCommand.getNum());
        return new FibonacciOutput(result);
    }

    private int calculate(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return calculate(n - 1) + calculate(n - 2);
    }
}
