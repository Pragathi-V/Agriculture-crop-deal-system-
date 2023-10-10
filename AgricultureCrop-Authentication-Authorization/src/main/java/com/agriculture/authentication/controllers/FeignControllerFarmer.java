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

import com.agriculture.authentication.exception.FarmerNotFoundException;
import com.agriculture.authentication.exception.NoProperDataException;
import com.agriculture.authentication.models.Farmer;
import com.agriculture.authentication.service.SequenceGeneratorService;
import com.agriculture.authentication.util.FiegnClientUtilFarmer;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/farmer")
public class FeignControllerFarmer {
	

	@Autowired
	private FiegnClientUtilFarmer feignfarmer;
	
	
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping("/ListFarmer") 
	@PreAuthorize(" hasRole('ADMIN')")
	public ResponseEntity<List<Farmer>> getAllFarmer() throws FarmerNotFoundException
	{
		
		return feignfarmer.getAllFarmer();
		
	}
	
	@GetMapping("/ListFarmer/{id}")
	@PreAuthorize("hasRole('DEALER') or hasRole('ADMIN')")
	public ResponseEntity getFarmer(@PathVariable("id")  int id) throws FarmerNotFoundException{
		return feignfarmer.getFarmer(id);
	}
	
	@PostMapping("/addFarmer") 
	@PreAuthorize("hasRole('FARMER')or hasRole('ADMIN')")
	public ResponseEntity<Farmer> addFarmer(@RequestBody Farmer farmer)  throws NoProperDataException
	{
		farmer.setId(service.getSequenceNumberForFarmer(Farmer.SEQUENCE_NAME));
		return feignfarmer.addFarmer(farmer);
	}


	@DeleteMapping(path="/deleteFarmer/{id}")
	@PreAuthorize("hasRole('ADMIN')")	
	public ResponseEntity deleteFarmer(@PathVariable int id) throws FarmerNotFoundException {
			return feignfarmer.deleteFarmer(id);
	}

}
