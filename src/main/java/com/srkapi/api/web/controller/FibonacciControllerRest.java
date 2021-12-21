package com.srkapi.api.web.controller;


import com.srkapi.api.application.port.in.model.FibonacciRequestCommand;
import com.srkapi.api.application.port.in.model.FibonacciResponse;
import com.srkapi.api.application.usecase.CalculateFibonacciUseCases;
import com.srkapi.api.shared.ApplicationException;
import com.srkapi.api.shared.DomainException;
import com.srkapi.api.web.controller.request.CalculatorRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@Api(value = "fibonacci service")
@RequestMapping("/fibonacci")
public class FibonacciControllerRest {

    private final CalculateFibonacciUseCases fibonacciUseCases;

    @RequestMapping( method = RequestMethod.POST,consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    @ApiOperation(value = "calculator fibonacci")
    public ResponseEntity calculateFibonacci(@RequestBody @Valid CalculatorRequest request) throws ApplicationException {
        try {
            FibonacciResponse result = this.fibonacciUseCases.execute(new FibonacciRequestCommand(request.getNumber()));
            return ResponseEntity.ok().body(result);
        } catch (DomainException e) {
            throw new ApplicationException(e.getCode(), e.getDetail());
        }
    }
}
