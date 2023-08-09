package com.codmind.swaggerapi.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;





@ControllerAdvice
public class RestResponseEntityExceptionHandler 
  extends ResponseEntityExceptionHandler {
	
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {  
    	
    	if (ex.getClass().getName()=="com.codmind.swaggerapi.exception.DachserException") {
    	  String bodyOfResponse =  ex.getLocalizedMessage();
    	  return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    	} else if (ex.getClass().getName()=="javax.validation.ConstraintViolationException") {
    		String bodyOfResponse =  ex.getLocalizedMessage();
    		return handleExceptionInternal(ex, bodyOfResponse,	new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    	} else {
    		String bodyOfResponse = "Ooops . An unexpected error has ocurred . Please contact an adminsitrator ";
    		return handleExceptionInternal(ex, bodyOfResponse,	new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);    		
    	}
    }
  
}
