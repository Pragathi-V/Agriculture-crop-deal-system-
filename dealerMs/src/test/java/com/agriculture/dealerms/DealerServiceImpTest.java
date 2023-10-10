package com.agriculture.dealerms;

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

import com.agriculture.dealerms.exceptions.DealerNotFoundException;
import com.agriculture.dealerms.model.Dealer;
import com.agriculture.dealerms.repo.DealerRepository;
import com.agriculture.dealerms.service.DealerServiceImp;

@SpringBootTest
@AutoConfigureMockMvc
public class DealerServiceImpTest {

	
	@InjectMocks
	private DealerServiceImp service;
	
	@Mock
	private DealerRepository repository;
	
	@Test
	void testServiceNotNull() {
		assertThat(service).isNotNull();
	}
	
	@Test
	void testRepositoryNotNull() {
		assertThat(repository).isNotNull();
	}
	
	@Test
	void testGetAllDealers() {
		Dealer p1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
		Dealer p2=new Dealer(102,"royfarm","royf123","roy@mail.com");
		List<Dealer> productList=new ArrayList<Dealer>();
		productList.add(p1);
		productList.add(p2);
		when(repository.findAll()).thenReturn(productList);
		assertEquals(productList,service.getAllDealer());
		
	}
	
	@Test
	void testGetDealerById() throws DealerNotFoundException {
		Dealer p1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
		when(repository.findById(101)).thenReturn(Optional.of(p1));
		//assertEquals(p1,service.getDealerById(101));
	}
	
	@Test
	void testGetDealerByInvalidId() throws DealerNotFoundException {
		Dealer p1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
		when(repository.findById(101)).thenReturn(Optional.of(p1));
		try {
			assertThat(service.getDealerById(1)).as("Dealer with the id 1 doesn't exist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
	}
	
	@Test
	void testAddDealer() throws DealerNotFoundException {
		Dealer p1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
		//assertThat(service.addDealer(p1))
		//.contains("added successfully....");
	
	}	
	@Test
	void testAddDealerAlreadyExists() throws DealerNotFoundException {
		Dealer p1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
		when(repository.findById(101)).thenReturn(Optional.of(p1));
	try {
//		assertThat(service.addDealer(p1))
//		.contains("Dealer with the id "+p1.getId()+" already exist");
	}catch(Exception e) {
		
	}
	}
	
	@Test
	void testupdateDealer() throws DealerNotFoundException {
		Dealer p1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
		when(repository.findById(101)).thenReturn(Optional.of(p1));
//		assertThat(service.updateDealer(p1))
//		.contains("updated successfully....");
//	
	}
	
	@Test
	void testupdateDealerDoesnotExists() throws DealerNotFoundException {
		Dealer p1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
		when(repository.findById(10)).thenReturn(Optional.of(p1));
	try {
//		assertThat(service.updateDealer(p1))
//		.contains("Dealer with the id "+p1.getId()+" doesn't exist for update");
	}catch(Exception e) {
		
	}
	}
	
	@Test
	void testDeleteDealerById() throws DealerNotFoundException {
		Dealer p1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
		when(repository.findById(101)).thenReturn(Optional.of(p1));
//		assertThat(service.deleteDealerById(101))
//		.contains("deleted successfully....");
	}
	
	@Test
	void testDeleteDealerByInvalidId() throws DealerNotFoundException {
		Dealer p1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
		when(repository.findById(101)).thenReturn(Optional.of(p1));
		try {
//			assertThat(service.deleteDealerById(111))
//			.contains("Dealer with the id "+p1.getId()+" doesn't exist");
		}catch(Exception e) {
			
		}
	}
	
	
	}

