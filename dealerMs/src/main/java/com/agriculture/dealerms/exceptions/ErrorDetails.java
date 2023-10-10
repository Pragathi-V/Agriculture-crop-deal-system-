package com.agriculture.dealerms.exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {
    
	private String ErrorMessage;
	private LocalDateTime TimeStamp;
	
	public void setErrorMessage(String message) {
		// TODO Auto-generated method stub
		
	}
	public void setTimeStamp(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}
	
	}
