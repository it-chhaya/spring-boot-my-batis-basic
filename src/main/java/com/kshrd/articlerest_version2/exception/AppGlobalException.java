package com.kshrd.articlerest_version2.exception;

import com.kshrd.articlerest_version2.rest.response.ApiResponse;
import com.kshrd.articlerest_version2.rest.response.ArticleRest;
import com.kshrd.articlerest_version2.rest.response.BaseResponse;

import com.kshrd.articlerest_version2.rest.response.ErrorResponse;
import com.kshrd.articlerest_version2.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;

@ControllerAdvice
public class AppGlobalException {

    private DateTimeUtils dateTimeUtils;

    @Autowired
    public void setDateTimeUtils(DateTimeUtils dateTimeUtils) {
        this.dateTimeUtils = dateTimeUtils;
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> generateException(ResponseStatusException ex) {

        ErrorResponse response = new ErrorResponse();

        response.setMessage(ex.getMessage());
        response.setStatusCode(ex.getStatus().value());
        response.setTime(dateTimeUtils.getCurrentTimestamp());
        response.setCode(3000);
        response.setDetails("You article ID that provided is not existed in the database");

        return new ResponseEntity<>(response, ex.getStatus());

    }

}
