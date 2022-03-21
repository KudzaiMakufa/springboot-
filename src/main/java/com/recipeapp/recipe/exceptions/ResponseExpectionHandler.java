package com.recipeapp.recipe.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
// applies to all contollers
@ControllerAdvice
@RestController
public class ResponseExpectionHandler  extends ResponseEntityExceptionHandler{
    // handing an exception
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request)  {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false)) ;

     return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // Resource not found exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Object> handleUserNOtFoudException(ResourceNotFoundException ex, WebRequest request)  {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false)) ;

     return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }

    // overide method for validations 
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
            ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), ex.getBindingResult().toString()) ;
            return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}

}