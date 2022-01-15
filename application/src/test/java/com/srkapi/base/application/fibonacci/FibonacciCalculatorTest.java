package com.srkapi.base.application.fibonacci;


import com.srkapi.base.application.fibonacci.values.FibonacciInput;
import com.srkapi.base.application.fibonacci.values.FibonacciOutput;
import com.srkapi.base.shared.domain.DomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FibonacciCalculatorTest {
    private FibonacciCalculator fibonacciCalculator;

    @BeforeEach
    void setUp() {
        fibonacciCalculator = new FibonacciCalculator();
    }

    @Test
    public void shouldReturnExceptionWhenValueIsNegative() {
        Assertions.assertThrows(DomainException.class, () -> fibonacciCalculator.execute(new FibonacciInput(-8)));
    }

    @Test
    public void shouldReturnResultWhenCommandIsCorrect() throws DomainException {
        FibonacciOutput response = fibonacciCalculator.execute(new FibonacciInput(4));
        Assertions.assertTrue(response.getResult() >= 0);
    }

}
