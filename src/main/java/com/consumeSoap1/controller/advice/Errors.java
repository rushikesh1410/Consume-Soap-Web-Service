package com.consumeSoap1.controller.advice;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Errors {

	private Map<String,String> errorMessage;
	
	
    //getters and setters
	public Map<String, String> getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(Map<String, String> errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	//Constructor using fields
	public Errors(Map<String, String> errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	//constructor using super
	public Errors() {
		super();
	}
	

	
	
}
