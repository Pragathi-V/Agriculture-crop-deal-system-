package com.agriculture.authentication.util;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.agriculture.authentication.models.Farmer;



@FeignClient(value="FarmerData",url="http://localhost:8082/farmer")
public interface FiegnClientUtilFarmer {
	
	@GetMapping("/ListFarmer") 
	public ResponseEntity<List<Farmer>> getAllFarmer();
	
	
	@GetMapping("/ListFarmer/{id}")
	
	public ResponseEntity<Farmer> getFarmer(@PathVariable int id);
	
	
	@PostMapping("/addFarmer") 
	public ResponseEntity<Farmer> addFarmer(Farmer Farmer);

	
	
	@DeleteMapping(path="/deleteFarmer/{id}")
	public ResponseEntity<String> deleteFarmer(@PathVariable int id);


}
