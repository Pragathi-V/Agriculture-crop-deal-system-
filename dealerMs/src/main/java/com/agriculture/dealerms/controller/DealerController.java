package com.agriculture.dealerms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
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

import com.agriculture.dealerms.exceptions.DealerNotFoundException;
import com.agriculture.dealerms.exceptions.NoProperDataException;
import com.agriculture.dealerms.model.Dealer;
import com.agriculture.dealerms.service.SequenceGeneratorService;

import io.swagger.annotations.ApiOperation;

import com.agriculture.dealerms.service.DealerServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/dealer")
@Validated
@CrossOrigin("*")
public class DealerController {
	Logger logger= LoggerFactory.getLogger(DealerController.class);

	@Autowired
	private DealerServiceImp dealerServiceimpl;

	@Autowired
	private SequenceGeneratorService service;

	@ApiOperation(value = "Add Dealer",response=Dealer.class)
	@PostMapping("/addDealer")
	public ResponseEntity<Dealer> addDealer(@RequestBody Dealer dealer)  throws NoProperDataException{
		if(dealer!=null) 
		{
			
			dealer.setId(service.getSequenceNumberForDealer(Dealer.SEQUENCE_NAME));
			dealerServiceimpl.addDealer(dealer);
			logger.info("added dealer");
			return new ResponseEntity<>(dealer,HttpStatus.CREATED);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
	}

	@ApiOperation(value = "List all  dealers",response=Iterable.class)

	@GetMapping("/ListDealer")
	public ResponseEntity<List<Dealer>> getAllDealer(String name) throws DealerNotFoundException  {
		//Dealer dealer=dealerRepository.findAll();
		List<Dealer> dealers=dealerServiceimpl.getAllDealer();
		logger.info("starting  of get mapping");
	
		if(dealers.size()>0) {
			logger.info("dealers are {}"+ dealers);
		 return new  ResponseEntity<>(dealers,HttpStatus.OK); 
		}
		else {
			logger.error(" no dealers found ");
			 return new  ResponseEntity<>(dealers,HttpStatus.NO_CONTENT); 
		}
	}


	@ApiOperation(value = "List dealers by id",response= Dealer.class)
	@GetMapping("/ListDealer/{id}")
	public ResponseEntity<Dealer> getDealer(@PathVariable int id )  throws DealerNotFoundException {
		Optional<Dealer> dealerdata= dealerServiceimpl.findById(id);
		logger.info("starting  of get mapping");
		Dealer dealers=dealerServiceimpl.getDealer(id);
	
		if(dealers.getId()!=0) {
			logger.info("dealers are {}"+ dealers);
		 return new  ResponseEntity<>(dealers,HttpStatus.OK); 
		}
		else {
			logger.error(" no dealers found ");
			 return new  ResponseEntity<>(dealers,HttpStatus.NOT_FOUND); 
		}
	}

	@ApiOperation(value = "delete dealer by id",response= Dealer.class)
	@DeleteMapping("/deleteDealer/{id}")
	public ResponseEntity<HttpStatus> deleteDealer(@PathVariable int id) throws DealerNotFoundException {
			
		try {
			dealerServiceimpl.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "delete all dealers",response= Dealer.class)
	@DeleteMapping("/deleteAllDealers")
	public ResponseEntity<String> deleteAllDealers( ){
		try {
			dealerServiceimpl.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e)
		{
			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "update dealer by id",response= Dealer.class)
	@PutMapping("/updateDealer/{id}")
	public ResponseEntity<Dealer> updateDealer(@Valid @RequestBody Dealer dealer, @PathVariable int id) {
		Optional<Dealer> dealerdata= dealerServiceimpl.findById(id);
		if(dealerdata.isPresent())
		{
			Dealer c= dealerdata.get();
			c.setName(dealer.getName());
			
			
			return new ResponseEntity<>(dealerServiceimpl.save(c),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		
	
}
