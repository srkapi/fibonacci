package com.srkapi.base.api.exceptions;

import com.srkapi.base.shared.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		ErrorResponse error = ErrorResponse.builder().message("Validation Failed").errors(details).build();
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler({ApplicationException.class, Exception.class})
	@ResponseBody
	protected ResponseEntity<Object> handleApplicationExceptions(Exception ex) {
		log.error(ex.getMessage());
		return ErrorResponseFactory.build(ex);
	}
}
