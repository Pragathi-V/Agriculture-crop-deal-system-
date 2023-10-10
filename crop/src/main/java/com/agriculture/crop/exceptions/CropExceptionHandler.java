package com.agriculture.crop.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CropExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorDetails> handleException(Exception e){
		ErrorDetails errorDetails= new ErrorDetails();
		errorDetails.setErrorMessage(e.getMessage());
		errorDetails.setTimeStamp(LocalDateTime.now());
		return  new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
}