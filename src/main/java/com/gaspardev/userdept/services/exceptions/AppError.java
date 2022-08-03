package com.gaspardev.userdept.services.exceptions;

import org.springframework.http.HttpStatus;

public class AppError extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;
	
	public AppError(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	


}
