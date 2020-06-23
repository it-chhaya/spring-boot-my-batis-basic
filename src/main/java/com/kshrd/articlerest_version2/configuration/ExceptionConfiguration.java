package com.kshrd.articlerest_version2.configuration;

import com.kshrd.articlerest_version2.rest.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ExceptionConfiguration {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handle(
            ResponseStatusException e
        ) {

        ErrorResponse response = new ErrorResponse();
        response.setCode(9999);
        response.setDetails(e.getMessage());

        return ResponseEntity.ok(response);

    }

}
