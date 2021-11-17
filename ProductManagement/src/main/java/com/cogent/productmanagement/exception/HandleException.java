package com.cogent.productmanagement.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class HandleException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> ResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
		System.out.println("the unit cannot be found");
		ErrorDetails ed = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
		
	}
	public ResponseEntity<?> Exception(Exception e, WebRequest request){
		
		ErrorDetails ed= new ErrorDetails(new Date(), e.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
