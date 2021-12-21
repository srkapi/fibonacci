package com.srkapi.api.fibonacci.application;

import com.srkapi.api.fibonacci.application.command.FibonacciCommand;
import com.srkapi.api.fibonacci.application.command.FibonacciCommandResult;
import com.srkapi.api.shared.DomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FibonacciCalculatorTest {
    private FibonacciCalculator fibonacciCalculator;

    @BeforeEach
    void setUp() {
        fibonacciCalculator = new FibonacciCalculator();
    }

    @Test
    public void shouldReturnExceptionWhenValueIsNegative() {
        Assertions.assertThrows(DomainException.class, () -> fibonacciCalculator.execute(new FibonacciCommand(-8)));
    }

    @Test
    public void shouldReturnResultWhenCommandIsCorrect() throws DomainException {
        FibonacciCommandResult response = fibonacciCalculator.execute(new FibonacciCommand(4));
        Assertions.assertTrue(response.getResult()>=0);
    }

}
