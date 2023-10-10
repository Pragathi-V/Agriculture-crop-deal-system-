package com.cropdeal.farmer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FarmerNotFoundException extends Exception {

	public FarmerNotFoundException(String message) {
		super(message);

	}
 
}