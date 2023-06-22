package com.consumeSoap1.controller.advice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandler {
	
	@Autowired
	private Errors errorClass;
	

	//400 bad request
	
	@org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<Errors> handleInvalidArgument(Exception ex, HttpServletRequest req) {
	
		HttpHeaders headers = new HttpHeaders();

		Map<String, String> errors = new HashMap<>();


		if (req.getHeader("Content-Type").equals("application/json")) {

			String error = ex.getMessage();

			if (error.contains("Cannot deserialize value of type `int` from String")) {
				error = "intA or intB must be a number";
				errors.put("invalidParameters", error);
			}
			
			if (error.contains("was expecting comma to separate Object entries")) {
				error = "Expecting comma to separate object entries";
				errors.put("syntaxError", error);
			}
			
			if (error.contains("Unexpected character (',' (code 44)): expected a value")) {
				error = "expected a value at intA";
				errors.put("missingParameters", error);
			}
			
			if (error.contains("Unexpected character ('}' (code 125)): expected a value")) {
				error = "expected a value at intB ";
				errors.put("missingParameters", error);
			}
			
			if (error.contains("Cannot construct instance of `com.consumeSoap1.output.Response` (although at least one Creator exists)")) {
				error = "missing curly brace at Start";
				errors.put("syntaxError", error);
			}
			
			if (error.contains("Unexpected end-of-input: expected close marker for Object ")) {
				error = "missing curly brace at End";
				errors.put("syntaxError", error);
			}
			
			if (error.contains("was expecting double-quote to start field name")) {
				error = "expecting double-quote with field name";
				errors.put("syntaxError", error);
			}
		}

		if (req.getHeader("Content-Type").equals("application/xml")) {
			
			String error = ex.getMessage();
			
			if (error.contains("Cannot deserialize value of type `int` from String")) {
				error = "intA or intB must be a number";
				errors.put("invalidParameters", error);
			}

			if (error.contains("was expecting a close tag for element")) {
				error = "expecting a closing tag at end";
				errors.put("syntaxError", error);
			}
			
			if (error.contains("Unexpected character '<' (code 60) in end tag Expected '>'")) {
				error = "check end tag is expected '>' ";
				errors.put("syntaxError", error);
			}
			
			if (error.contains("Unexpected character '<' (code 60) expected space, or '>'")) {
				error = "check end tag is expected '>' ";
				errors.put("syntaxError", error);
			}
			
			if (error.contains("expected </intB>")) {
				error = "check end tag is expected '</intB>' ";
				errors.put("syntaxError", error);
			}

			if (error.contains("expected </intA>")) {
				error = "check end tag is expected '</intA>' ";
				errors.put("syntaxError", error);
			}
					
		}

		errorClass.setErrorMessage(errors);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(errorClass);
	}

	
	
	
	
	
}
