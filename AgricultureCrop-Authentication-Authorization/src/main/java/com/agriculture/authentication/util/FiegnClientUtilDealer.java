package com.agriculture.authentication.util;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.agriculture.authentication.models.Dealer;



@FeignClient(value="CropSystem",url="http://localhost:8086/dealer")
public interface FiegnClientUtilDealer {
	
	@GetMapping("/ListDealer") 
	public ResponseEntity<List<Dealer>> getAllDealer();
	
	
	@GetMapping("/ListDealer/{id}")
	
	public ResponseEntity<Dealer> getDealer(@PathVariable( "id")int id);
	
	
	@PostMapping("/addDealer") 
	public ResponseEntity<Dealer> addDealer(Dealer dealer);

	
	
	@DeleteMapping(path="/deleteDealer/{id}")
	public ResponseEntity<String> deleteDealer(@PathVariable( "id") int id);
	

}
