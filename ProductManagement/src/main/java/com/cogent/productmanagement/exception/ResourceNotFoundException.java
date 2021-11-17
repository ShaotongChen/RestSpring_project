package com.cogent.productmanagement.exception;

public class ResourceNotFoundException extends Exception{
	
	public ResourceNotFoundException(String mess) {
		System.out.println("the message is : "+mess );
	}

}
