package com.agriculture.authentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CropNotFoundException extends Exception {

	public CropNotFoundException(String message) {
		super(message);

	}
 
}
