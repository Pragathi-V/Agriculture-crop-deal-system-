package com.agriculture.authentication.controllers;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.agriculture.authentication.exception.RoleNotFoundException;
import com.agriculture.authentication.models.MyErrorResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler({RoleNotFoundException.class})
	public ResponseEntity<MyErrorResponse> handleCropNotFound(RoleNotFoundException ex){
				MyErrorResponse error=new MyErrorResponse();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND);
		error.setMessage(ex.getMessage());
		error.setReason("id doesn't exist....");
		return new ResponseEntity<MyErrorResponse>(error,HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler({MethodArgumentTypeMismatchException.class})
	public ResponseEntity<MyErrorResponse> handleBadRequest(MethodArgumentTypeMismatchException ex){
				MyErrorResponse error=new MyErrorResponse();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.BAD_REQUEST);
		error.setMessage(ex.getMessage());
		error.setReason("Wrong url/method typed ....");
		return new ResponseEntity<MyErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler({HttpRequestMethodNotSupportedException.class})
	public ResponseEntity<MyErrorResponse> handleMethodNotSupportException(HttpRequestMethodNotSupportedException ex){
				MyErrorResponse error=new MyErrorResponse();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.METHOD_NOT_ALLOWED);
		error.setMessage(ex.getMessage());
		error.setReason("Wrong method selected....");
		return new ResponseEntity<MyErrorResponse>(error,HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleException(Exception ex){
			Map<String,Object> body=new LinkedHashMap<String, Object>();
		body.put("timestamp",LocalDateTime.now());
		body.put("Status",HttpStatus.NOT_ACCEPTABLE);
		body.put("Message",ex.getMessage());
		body.put("Reason","Wrong url typed....");
		return new ResponseEntity<Object>(body,HttpStatus.NOT_ACCEPTABLE);
	}
}