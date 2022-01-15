package com.srkapi.base.api.controller;


import com.srkapi.base.api.controller.request.CalculatorRequest;
import com.srkapi.base.application.fibonacci.usecase.CalculateFibonacciUseCases;
import com.srkapi.base.application.fibonacci.values.FibonacciInput;
import com.srkapi.base.application.fibonacci.values.FibonacciOutput;
import com.srkapi.base.shared.domain.ApplicationException;
import com.srkapi.base.shared.domain.DomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/fibonacci")
public class FibonacciControllerRest {

    private final CalculateFibonacciUseCases fibonacciUseCases;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity calculateFibonacci(@RequestBody @Valid CalculatorRequest request) throws ApplicationException {
        try {
            FibonacciOutput result = this.fibonacciUseCases.execute(new FibonacciInput(request.getNumber()));
            return ResponseEntity.ok().body(result);
        } catch (DomainException e) {
            throw new ApplicationException(e.getCode(), e.getDetail());
        }
    }
}
