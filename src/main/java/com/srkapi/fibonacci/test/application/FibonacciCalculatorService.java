package com.srkapi.fibonacci.test.application;

import com.srkapi.fibonacci.test.application.exception.ErrorValueException;
import com.srkapi.fibonacci.test.application.port.in.model.FibonacciRequestCommand;
import com.srkapi.fibonacci.test.application.port.in.model.FibonacciResponse;
import com.srkapi.fibonacci.test.application.usecase.CalculateFibonacciUseCases;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FibonacciCalculatorService implements CalculateFibonacciUseCases {


    @Override
    public FibonacciResponse process(FibonacciRequestCommand fibonacciRequestCommand) {
        FibonacciResponse response = FibonacciResponse.builder().build();
        if (fibonacciRequestCommand.getNum() > 0) {
            int result = calculator(fibonacciRequestCommand.getNum());
            response.setResult(result);
        } else {
            throw new ErrorValueException("value negative");
        }
        return response;
    }


    private int calculator(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return calculator(n - 1) + calculator(n - 2);
    }
}
