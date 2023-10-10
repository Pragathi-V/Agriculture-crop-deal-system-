package com.agriculture.authentication.util;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.agriculture.authentication.models.Crop;

@FeignClient(value="CropData",url="http://localhost:8080/crop")
public interface FiegnClientUtilCrop {
	
	@GetMapping("/ListCrop") 
	public ResponseEntity<List<Crop>> getAllCrop();
	
	
	@GetMapping("/ListCrop/{id}")
	
	public ResponseEntity<Crop> getCrop( @PathVariable( "id")int id);
	
	
	@PostMapping("/addCrop") 
	public ResponseEntity<Crop> addCrop(Crop crop);

	
	
	@DeleteMapping(path="/deleteCrop/{id}")
	public ResponseEntity<String> deleteCrop(@PathVariable( "id") int id);


	@PutMapping(path="/updateCrop/{id}")
	public ResponseEntity<Crop> updateCrop(@RequestHeader Crop crop,@PathVariable( "id")int id);



}
