package com.srkapi.base.api.exceptions;


import com.srkapi.base.shared.domain.ApplicationException;
import com.srkapi.base.shared.domain.Errors;
import java.util.List;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        return switch (ex.getCode()) {
            case CONFLICT -> new ResponseEntity<>(ErrorResponse.builder()
                .message(Errors.CONFLICT.name())
                .errors(List.of(Errors.CONFLICT.getDetail())).build(), HttpStatus.CONFLICT);
            case INVALID -> new ResponseEntity<>(ErrorResponse.builder()
                .message(Errors.INVALID.name())
                .errors(List.of(Errors.INVALID.getDetail())).build(), HttpStatus.BAD_REQUEST
            );
            case UNAUTHORIZED -> new ResponseEntity<>(ErrorResponse.builder()
                .message(Errors.UNAUTHORIZED.name())
                .errors(List.of(Errors.UNAUTHORIZED.getDetail())).build(), HttpStatus.UNAUTHORIZED
            );
            case NOT_FOUND -> new ResponseEntity<>(ErrorResponse.builder()
                .message(Errors.NOT_FOUND.name())
                .errors(List.of(Errors.NOT_FOUND.getDetail())).build(), HttpStatus.NOT_FOUND
            );
            case INTERNAL_ERROR -> new ResponseEntity<>(ErrorResponse.builder()
                .message(Errors.INTERNAL_ERROR.name())
                .errors(List.of(Errors.INTERNAL_ERROR.getDetail())).build(),
                HttpStatus.INTERNAL_SERVER_ERROR
            );
        };
    }
}
