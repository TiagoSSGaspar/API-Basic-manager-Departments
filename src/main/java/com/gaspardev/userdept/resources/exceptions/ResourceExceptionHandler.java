package com.gaspardev.userdept.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gaspardev.userdept.services.exceptions.AppError;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(AppError.class)
	public ResponseEntity<StandardError> appError(AppError appError, HttpServletRequest request) {
		//HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(Instant.now(), appError.getStatus().value(), appError.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(appError.getStatus()).body(standardError);
	}
	
}
