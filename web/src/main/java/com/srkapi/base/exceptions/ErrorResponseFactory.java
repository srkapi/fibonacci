package com.srkapi.base.exceptions;


import com.srkapi.base.shared.ApplicationException;
import com.srkapi.base.shared.Errors;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@UtilityClass
public class ErrorResponseFactory {
    public ResponseEntity<Object> build(Exception ex) {
        if (ex instanceof ApplicationException) {
            return buildApplicationException((ApplicationException) ex);
        }

        return new ResponseEntity<>(ErrorResponse.builder()
                .message(Errors.INTERNAL_ERROR.name())
                .errors(List.of(Errors.INTERNAL_ERROR.getDetail())).build(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    private ResponseEntity<Object> buildApplicationException(ApplicationException ex) {
        switch (ex.getCode()){
            case CONFLICT:
                return new ResponseEntity<>(ErrorResponse.builder()
                        .message(Errors.CONFLICT.name())
                        .errors(List.of(Errors.CONFLICT.getDetail())).build(), HttpStatus.CONFLICT);

            case INVALID:
                return new ResponseEntity<>(ErrorResponse.builder()
                        .message(Errors.INVALID.name())
                        .errors(List.of(Errors.INVALID.getDetail())).build(), HttpStatus.BAD_REQUEST
                );
            case UNAUTHORIZED:
                return new ResponseEntity<>(ErrorResponse.builder()
                        .message(Errors.UNAUTHORIZED.name())
                        .errors(List.of(Errors.UNAUTHORIZED.getDetail())).build(), HttpStatus.UNAUTHORIZED
                );
            case NOT_FOUND:
                return new ResponseEntity<>(ErrorResponse.builder()
                        .message(Errors.NOT_FOUND.name())
                        .errors(List.of(Errors.NOT_FOUND.getDetail())).build(), HttpStatus.NOT_FOUND
                );
            case INTERNAL_ERROR:
            default:
                return new ResponseEntity<>(ErrorResponse.builder()
                        .message(Errors.INTERNAL_ERROR.name())
                        .errors(List.of(Errors.INTERNAL_ERROR.getDetail())).build(), HttpStatus.INTERNAL_SERVER_ERROR
                );

        }
    }
}
