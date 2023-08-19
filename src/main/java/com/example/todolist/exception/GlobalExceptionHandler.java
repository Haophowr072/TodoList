package com.example.todolist.exception;

import com.example.todolist.dal.dto.ResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {


        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> errors =new ArrayList<>();

        for(FieldError fieldError : fieldErrors){
            String errorMessage = fieldError.getDefaultMessage();
            errors.add(errorMessage);
        }

        return new ResponseEntity<>(new ResponseDto(errors, HttpStatus.BAD_REQUEST.value(), "Validation Failed"),HttpStatus.BAD_REQUEST);
    }
}


