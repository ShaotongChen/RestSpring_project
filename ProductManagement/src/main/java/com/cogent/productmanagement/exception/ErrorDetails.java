package com.cogent.productmanagement.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDetails {

	private Date timetemp;
	private String message;
	private String details;
	
	
	
}
