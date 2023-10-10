package com.agriculture.crop.exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {
    
	private String errorMessage;
	private LocalDateTime timeStamp;
	
	public void setErrorMessage(String message) {
		
	}
	public void setTimeStamp(LocalDateTime now) {
		
	}
	
	
}
