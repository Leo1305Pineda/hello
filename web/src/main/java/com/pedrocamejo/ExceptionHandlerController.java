package com.pedrocamejo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pedrocamejo.exceptions.InvalidRequestException;
import com.pedrocamejo.exeptions.IdNotFountExecption;
 
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(InvalidRequestException.class)
	protected ResponseEntity<?> handlerInvalidRequest(RuntimeException runtimeException, WebRequest request ) throws JsonProcessingException{
		
		InvalidRequestException ire = (InvalidRequestException) runtimeException;
		Map<String,Object> errors = ire.getObtainsErrorMap(); 
	    
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    return handleExceptionInternal(runtimeException,new ObjectMapper().writeValueAsString(errors), headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
	}
	 
	
	@ExceptionHandler(IdNotFountExecption.class)
	protected ResponseEntity<?> handlerIdNotFound(RuntimeException runtimeException, WebRequest request) throws JsonProcessingException{
		Map<String,String> map = new HashMap<>();
		IdNotFountExecption idNotFountExecption = (IdNotFountExecption) runtimeException;
		map.put("idNotFound",idNotFountExecption.getMessage());
 		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(runtimeException,new ObjectMapper().writeValueAsString(map), headers, HttpStatus.NOT_FOUND, request);

	}
	

}
