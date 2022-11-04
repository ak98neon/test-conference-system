package com.redhash.conference.adaptors.api;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ProblemDetail handleValidationException(ConstraintViolationException ex) {
        var problemDetail = ProblemDetail.forStatus(400);
        problemDetail.setTitle("Validation error");
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;
    }
}
