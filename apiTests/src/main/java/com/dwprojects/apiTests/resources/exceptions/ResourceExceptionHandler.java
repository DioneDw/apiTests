package com.dwprojects.apiTests.resources.exceptions;

import com.dwprojects.apiTests.services.exceptions.DataIntegrityViolationException;
import com.dwprojects.apiTests.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError>objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandardError error = new StandardError(LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(), e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError>dataIntegrityViolation(DataIntegrityViolationException e, HttpServletRequest request){
        StandardError error = new StandardError(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(), e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
