package com.cts.main.ExceptionHandling;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
	
	private String message;
	private String details;
	private int httpStatusCode;

	
	
	
	public ErrorDetails(String message, String details, int i) {
		super();
		this.message = message;
		this.details = details;
		this.httpStatusCode = i;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	public int getHttpStatusCode() {
		return httpStatusCode;
	}
	
	
	

}
