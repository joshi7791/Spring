package com.cts.main.ExceptionHandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(EmployeeNotFoundException empNotFound,WebRequest wReq){
		ErrorDetails er=new ErrorDetails(empNotFound.getMessage(),wReq.getDescription(false),HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandler1(Exception ex,WebRequest wReq){
		ErrorDetails er=new ErrorDetails(ex.getMessage(),wReq.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@Override  // By overriding below method for 400 bad request methodargumentexception
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetails er=new ErrorDetails("validation fail",request.getDescription(false),HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<Object>(er,HttpStatus.BAD_REQUEST);
	}

}
