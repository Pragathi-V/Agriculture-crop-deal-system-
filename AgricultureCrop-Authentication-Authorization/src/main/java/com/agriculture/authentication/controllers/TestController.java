package com.agriculture.authentication.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/farmer")
	@PreAuthorize("hasRole('DEALER')  or hasRole('ADMIN')")
	public String farmerAccess() {
		return "Farmer Content.";
	}
	
	@GetMapping("/dealer")
	@PreAuthorize("hasRole('FARMER')  or hasRole('ADMIN')")
	public String dealerAccess() {
		return "Dealer Content.";
	}

	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
