package com.agriculture.crop.controller;

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

import com.agriculture.crop.exceptions.CropNotFoundException;
import com.agriculture.crop.exceptions.NoProperDataException;
import com.agriculture.crop.model.Crop;
import com.agriculture.crop.service.CropServiceImp;
import com.agriculture.crop.service.SequenceGeneratorService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@ApiOperation(value = "crop details",tags="Crop details controller")
@RestController
@RequestMapping("/crop")
@Validated

public class CropController {

	Logger logger= LoggerFactory.getLogger(CropController.class);	


	@Autowired
	private CropServiceImp cropServiceimpl;

	@Autowired
	private SequenceGeneratorService service;

	@ApiOperation(value = "Add Crops",response=Crop.class)
	@PostMapping("/addCrop")
	public ResponseEntity<Crop> addCrop(@Valid @RequestBody Crop crop) throws NoProperDataException  {
		if(crop!=null) 
		{
			
			crop.setId(service.getSequenceNumberForCrop(Crop.SEQUENCE_NAME));
			cropServiceimpl.addCrop(crop);
			logger.info("added crop");
			return new ResponseEntity<>(crop,HttpStatus.CREATED);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
	}
	
	@ApiOperation(value = "List all  Crops",response=Iterable.class)
	@GetMapping("/ListCrop")
	public ResponseEntity<List<Crop>> getAllCrop()  
	{
		List<Crop> crops=cropServiceimpl.getAllCrop();
		logger.info("starting  of get mapping");
	
		if(crops.isEmpty())
		{
			logger.debug(" no crops found ");
			 return new  ResponseEntity<>(crops,HttpStatus.NO_CONTENT); 
			
		}
		else {
			logger.info("crops are {}"+ crops);
			 return new  ResponseEntity<>(crops,HttpStatus.OK); 
		}
		
	}

	@ApiOperation(value = "List Crops by id",response= Crop.class)
	@GetMapping("/ListCrop/{id}")
	public ResponseEntity<Crop> getCrop(@PathVariable int id )  throws CropNotFoundException{
		
		logger.info("starting  of get mapping");
		Crop crops=cropServiceimpl.getCrop(id);
	
		if(crops.getId()!=0) {
			logger.info("crops are {}"+ crops);
		 return new  ResponseEntity<>(crops,HttpStatus.OK); 
		}
		else {
			logger.debug(" no crops found ");
			 return new  ResponseEntity<>(crops,HttpStatus.NOT_FOUND); 
		}
	}

	@ApiOperation(value = "delete Crops by id",response= Crop.class)
	@DeleteMapping("/deleteCrop/{id}")
	public ResponseEntity<HttpStatus> deleteCrop(@PathVariable int id) {
		
		try {
			cropServiceimpl.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "delete all Crops",response= Crop.class)
	@DeleteMapping("/deleteAllCrops")
	public ResponseEntity<String> deleteAllCrops( ){
		try {
			cropServiceimpl.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e)
		{
			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "update Crops by id",response= Crop.class)
	@PutMapping("/updateCrop/{id}")
	public ResponseEntity<Crop> updateCrop(@Valid @RequestBody Crop crop, @PathVariable int id) {
		Optional<Crop> cropdata= cropServiceimpl.findById(id);
		if(cropdata.isPresent())
		{
			Crop c= cropdata.get();
			c.setName(crop.getName());
			c.setType(crop.getType());
			c.setPrice(crop.getPrice());
			
			return new ResponseEntity<>(cropServiceimpl.save(c),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/s/{name}")
	public Crop findByName(@PathVariable("name") String name) {
		Crop op = cropServiceimpl.findByName(name);

		return op;
	}	
	
}
