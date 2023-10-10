package com.cropdeal.farmer.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropdeal.farmer.exceptions.FarmerNotFoundException;
import com.cropdeal.farmer.exceptions.NoProperDataException;
import com.cropdeal.farmer.model.Farmer;
import com.cropdeal.farmer.service.FarmerServiceImp;
import com.cropdeal.farmer.service.SequenceGeneratorService;

import io.swagger.annotations.ApiOperation;

//import lombok.extern.slf4j.Slf4j;

@RestController
//@Slf4j
@RequestMapping("/farmer")
@Validated
@CrossOrigin("*")

public class FarmerController {

	Logger logger= LoggerFactory.getLogger(FarmerController.class);
	@Autowired
	private FarmerServiceImp farmerServiceimpl;

	@Autowired
	private SequenceGeneratorService service;

	@ApiOperation(value = "Add Farmers",response=Farmer.class)
	@PostMapping("/addFarmer")
	public ResponseEntity<Farmer> addFarmer(@RequestBody Farmer farmer) throws NoProperDataException {
		if(farmer!=null) 
		{
			
			farmer.setId(service.getSequenceNumberForFarmer(Farmer.SEQUENCE_NAME));
			farmerServiceimpl.addFarmer(farmer);
			//System.out.println("added crop");
			logger.info("added farmer");
			return new ResponseEntity<>(farmer,HttpStatus.CREATED);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
	}
	
	@ApiOperation(value = "List all  farmers",response=Iterable.class)
	@GetMapping("/ListFarmer")
	public ResponseEntity<List<Farmer>> getAllFarmer()  
	{
		List<Farmer> farmers=farmerServiceimpl.getAllFarmer();
		//System.out.println("starting  of get mapping");
		logger.info("starting  of get mapping");
		if(farmers.isEmpty())
		{
			 //System.out.println(" no farmer found ");
			 logger.info(" no farmer found ");
			 return new  ResponseEntity<>(farmers,HttpStatus.NO_CONTENT); 
			
		}
		else {
			 //System.out.println("farmers are {}"+ farmers);
			 logger.info("farmers are {}"+ farmers);
			 return new  ResponseEntity<>(farmers,HttpStatus.OK); 
		}
		
	}

	@ApiOperation(value = "List farmers by id",response= Farmer.class)
	@GetMapping("/ListFarmer/{id}")
	public ResponseEntity<Farmer> getFarmer(@Valid @PathVariable int id )  throws FarmerNotFoundException {
		
		//System.out.println("starting  of get mapping");
		logger.info("starting of get mapping");
		Farmer farmers=farmerServiceimpl.getFarmer(id);
	
		if(farmers.getId()!=0)
		{
			//System.out.println("farmer are {}"+ farmers);
			logger.info("farmer are {}"+ farmers);
		    return new  ResponseEntity<>(farmers,HttpStatus.OK); 
		}
		else 
		{
			 //System.out.println(" no farmer found ");
			 logger.info("no farmer found");
			 return new  ResponseEntity<>(farmers,HttpStatus.NOT_FOUND); 
		}
	}

	@ApiOperation(value = "Delete farmer  by id",response= Farmer.class)
	@DeleteMapping("/deleteFarmer/{id}")
	public ResponseEntity<HttpStatus> deleteFarmer(@Valid @PathVariable int id) {
		
		try
		{
			farmerServiceimpl.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "delete all farmers",response= Farmer.class)
	@DeleteMapping("/deleteAllFarmer")
	public ResponseEntity<String> deleteAllFarmer( ) {
		try 
		{
			farmerServiceimpl.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e)
		{
			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "update farmer by id",response= Farmer.class)
	@PutMapping("/updateFarmer/{id}")
	public ResponseEntity<Farmer> updateFarmer(@Valid @RequestBody Farmer farmer, @PathVariable int id) {
		Optional<Farmer> farmerdata= farmerServiceimpl.findById(id);
		if(farmerdata.isPresent())
		{
			Farmer c= farmerdata.get();
			c.setName(farmer.getName());
			
			return new ResponseEntity<>(farmerServiceimpl.save(c),HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		
	
}