package com.srkapi.api.application;

import com.srkapi.api.application.exception.ErrorValueException;
import com.srkapi.api.application.port.in.model.FibonacciRequestCommand;
import com.srkapi.api.application.port.in.model.FibonacciResponse;
import com.srkapi.api.application.usecase.CalculateFibonacciUseCases;
import com.srkapi.api.shared.DomainException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
public class FibonacciCalculator implements CalculateFibonacciUseCases {
    public static final int FINAL_VALUE = 0;

    @Override
    public FibonacciResponse execute(FibonacciRequestCommand fibonacciRequestCommand) throws DomainException {
        if (fibonacciRequestCommand.getNum() <= 0) throw new ErrorValueException("value is negative");
        int result = calculator(fibonacciRequestCommand.getNum());
        return new FibonacciResponse(result);
    }

    private int calculator(int n) {
        if (n == FINAL_VALUE)
            return FINAL_VALUE;
        else if (n == 1)
            return 1;
        else
            return calculator(n - 1) + calculator(n - 2);
    }
}
