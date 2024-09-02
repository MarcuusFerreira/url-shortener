package com.marcus.url_shortener.infra.controller;

import com.marcus.url_shortener.domain.exceptions.PathNotFoundException;
import com.marcus.url_shortener.infra.dto.RestErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PathNotFoundException.class)
    private ResponseEntity<?> pathNotFoundHandler(PathNotFoundException exception) {
        var body = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
