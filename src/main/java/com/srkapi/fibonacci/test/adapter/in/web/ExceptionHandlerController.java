package com.srkapi.fibonacci.test.adapter.in.web;

import com.srkapi.fibonacci.test.application.exception.ErrorValueException;
import com.srkapi.fibonacci.test.application.port.in.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(ErrorValueException.class)
    public ResponseEntity<ErrorMessage> handleErrorValueException(
            ErrorValueException ex) {

        ErrorMessage result = new ErrorMessage(ex.getMsg(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<ErrorMessage>(result, HttpStatus.BAD_REQUEST);
    }
}
