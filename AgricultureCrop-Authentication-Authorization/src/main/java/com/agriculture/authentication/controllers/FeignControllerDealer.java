package com.agriculture.authentication.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agriculture.authentication.exception.DealerNotFoundException;
import com.agriculture.authentication.exception.NoProperDataException;
import com.agriculture.authentication.models.Dealer;
import com.agriculture.authentication.service.SequenceGeneratorService;
import com.agriculture.authentication.util.FiegnClientUtilDealer;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/dealer")
public class FeignControllerDealer {
	

	@Autowired
	private FiegnClientUtilDealer feigndealer;
	
	
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping("/ListDealer") 
	@PreAuthorize(" hasRole('ADMIN')")
	public ResponseEntity<List<Dealer>> getAllDealer() throws DealerNotFoundException
	{
		
		return feigndealer.getAllDealer();
		
	}
	
	@GetMapping("/ListDealer/{id}")
	@PreAuthorize(" hasRole('ADMIN')")
	public ResponseEntity getDealer(@PathVariable("id")  int id) throws DealerNotFoundException{
		return feigndealer.getDealer(id);
	}
	
	@PostMapping("/addDealer") 
	@PreAuthorize("hasRole('ADMIN')or hasRole('DEALER')")
	public ResponseEntity<Dealer> addDealer(@RequestBody Dealer dealer)  throws NoProperDataException
	{
		dealer.setId(service.getSequenceNumberForDealer(Dealer.SEQUENCE_NAME));
		return feigndealer.addDealer(dealer);
	}


	@DeleteMapping(path="/deleteDealer/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity deleteDealer(@PathVariable int id) throws DealerNotFoundException {
			return feigndealer.deleteDealer(id);
	}

}
