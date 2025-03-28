package com.leo.crud.vendas.controller.handler.exceptions;

import com.leo.crud.vendas.dto.errors.CustomError;
import com.leo.crud.vendas.exceptions.NotExistsResources;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@ControllerAdvice
@RestControllerAdvice
public class ControllerAdivice {

    @ExceptionHandler(NotExistsResources.class)
    public ResponseEntity<CustomError> notExistsResource(NotExistsResources exception, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        CustomError customError = new CustomError(
                Instant.now(),
                status.value(),
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(customError);
    }
}
