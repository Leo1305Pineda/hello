package com.pedrocamejo.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class InvalidRequestException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BindingResult result;
	
	public InvalidRequestException(String message,BindingResult result) {
		super(message);
		this.result = result;
	}

	public BindingResult getResult() {
		return result;
	}

	public Map<String, Object> getObtainsErrorMap() {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		if(result.hasErrors()){
			for(FieldError fieldError: result.getFieldErrors()){
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
		}
		return map;
	}
	
	
}
