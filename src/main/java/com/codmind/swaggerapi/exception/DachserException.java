package com.codmind.swaggerapi.exception;

public class DachserException extends RuntimeException{
	
	// Custom error message
    private String message;
	
	public DachserException() {
        super();
    }

	public DachserException(String message) {
	   super(message);
	   this.message = message;
	      
	}

}
