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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agriculture.authentication.exception.CropNotFoundException;
import com.agriculture.authentication.exception.NoProperDataException;
import com.agriculture.authentication.models.Crop;
import com.agriculture.authentication.service.SequenceGeneratorService;
import com.agriculture.authentication.util.FiegnClientUtilCrop;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/crop")
public class FeignControllerCrop {
	

	@Autowired
	private FiegnClientUtilCrop feigncrop;
	
	
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping("/ListCrop") 
	@PreAuthorize(" hasRole('ADMIN') or hasRole('DEALER') or hasRole('FARMER')")
	public ResponseEntity<List<Crop>> getAllCrop() 
	{
		
		return feigncrop.getAllCrop();
		
	}
	
	@GetMapping("/ListCrop/{id}")
	@PreAuthorize("hasRole('FARMER') or hasRole('ADMIN')")
	public ResponseEntity getCrop(@PathVariable( "id")int id) throws CropNotFoundException{
		
		return feigncrop.getCrop(id);
	}
	
	@PostMapping("/addCrop") 
	@PreAuthorize("hasRole('FARMER') or hasRole('ADMIN')")
	public ResponseEntity<Crop> addCrop(@RequestBody Crop crop)  throws NoProperDataException
	{
		crop.setId(service.getSequenceNumberForCrop(Crop.SEQUENCE_NAME));
		return feigncrop.addCrop(crop);
	}

	
	@DeleteMapping(path="/deleteCrop/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('FARMER')")
	public ResponseEntity deleteCrop(@PathVariable int id) throws CropNotFoundException {
			return feigncrop.deleteCrop(id);
	}

}
