package com.cropdeal.farmer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cropdeal.farmer.exceptions.FarmerNotFoundException;
import com.cropdeal.farmer.model.Farmer;
import com.cropdeal.farmer.repo.FarmerRepo;
import com.cropdeal.farmer.service.FarmerServiceImp;

@SpringBootTest
@AutoConfigureMockMvc
public class FarmerServiceImplTest {
	@InjectMocks
	private FarmerServiceImp service;
	
	@Mock
	private FarmerRepo repository;
	
	@Test
	void testServiceNotNull() {
		assertThat(service).isNotNull();
	}
	
	@Test
	void testRepositoryNotNull() {
		assertThat(repository).isNotNull();
	}
	
	@Test
	void testGetAllFarmers() {
		Farmer f1=new Farmer(101,"mirza@gmail.com", "Mirza@1", "mirza");
		Farmer f2=new Farmer(102, "kina@gmail.com", "Kina@1", "kina");
		List<Farmer> productList=new ArrayList<Farmer>();
		productList.add(f1);
		productList.add(f2);
		when(repository.findAll()).thenReturn(productList);
		assertEquals(productList,service.getAllFarmer());
		
	}
	
	@Test
	void testGetFamerById() throws FarmerNotFoundException {
		Farmer f1=new Farmer(101,"mirza@gmail.com", "Mirza@1", "mirza");
		when(repository.findById(101)).thenReturn(Optional.of(f1));
		//assertEquals(p1,service.getDealerById(101));
	}
	
	@Test
	void testGetFarmerByInvalidId() throws FarmerNotFoundException {
		Farmer p1=new Farmer(101,"mirza@gmail.com", "Mirza@1", "mirza");
		when(repository.findById(101)).thenReturn(Optional.of(p1));
		try {
			assertThat(service.getFarmer(1)).as("Farmer with the id 1 doesn't exist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
	}
	
	@Test
	void testAddFarmer() throws FarmerNotFoundException {
		Farmer f1=new Farmer(102, "kina@gmail.com", "Kina@1", "kina");
		//assertThat(service.addDealer(p1))
		//.contains("added successfully....");
	
	}	
	@Test
	void testAddFarmerAlreadyExists() throws FarmerNotFoundException {
		Farmer f1=new Farmer(102, "kina@gmail.com", "Kina@1", "kina");
		when(repository.findById(101)).thenReturn(Optional.of(f1));
	try {
//		assertThat(service.addDealer(p1))
//		.contains("Dealer with the id "+p1.getId()+" already exist");
	}catch(Exception e) {
		
	}
	}
	
	@Test
	void testupdateFarmer() throws FarmerNotFoundException {
		Farmer f1=new Farmer(102, "kina@gmail.com", "Kina@1", "kina");
		when(repository.findById(101)).thenReturn(Optional.of(f1));
//		assertThat(service.updateFarmer(p1))
//		.contains("updated successfully....");
//	
	}
	
	@Test
	void testupdateFarmerDoesnotExists() throws FarmerNotFoundException {
		Farmer p1=new Farmer(102, "kina@gmail.com", "Kina@1", "kina");
		when(repository.findById(10)).thenReturn(Optional.of(p1));
	try {
//		assertThat(service.updateFarmer(p1))
//		.contains("Farmer with the id "+p1.getId()+" doesn't exist for update");
	}catch(Exception e) {
		
	}
	}
	
	@Test
	void testDeleteFarmerById() throws FarmerNotFoundException {
		Farmer p1=new Farmer(102, "kina@gmail.com", "Kina@1", "kina");
		when(repository.findById(101)).thenReturn(Optional.of(p1));
//		assertThat(service.deleteFarmerById(101))
//		.contains("deleted successfully....");
	}
	
	@Test
	void testDeleteFarmerByInvalidId() throws FarmerNotFoundException {
		Farmer p1=new Farmer(102, "kina@gmail.com", "Kina@1", "kina");
		when(repository.findById(101)).thenReturn(Optional.of(p1));
		try {
//			assertThat(service.deleteFarmerById(111))
//			.contains("Farmer with the id "+p1.getId()+" doesn't exist");
		}catch(Exception e) {
			
		}
	}
	
	

}
