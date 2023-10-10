package com.cropdeal.farmer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cropdeal.farmer.model.Farmer;
import com.cropdeal.farmer.service.FarmerServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;




@SpringBootTest
@AutoConfigureMockMvc
public class FarmerControllerTest {
	
	@MockBean
	private FarmerServiceImp service;
	
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	void testServiceNotNull() {
		assertThat(service).isNotNull();
	}
	
	@Test
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}
	
	
	@Test
	void testShowFarmers() throws Exception {
		Farmer f1=new Farmer(101,"mirza@gmail.com", "Mirza@1", "mirza");
		Farmer f2=new Farmer(102, "kina@gmail.com", "Kina@1", "kina");
		List<Farmer> farmerList=new ArrayList<Farmer>();
		farmerList.add(f1);
		farmerList.add(f2);
		when(service.getAllFarmer()).thenReturn(farmerList);
	mockMvc.perform(get("/farmers/"));
//	.andExpect(status().isOk())
//	.andExpect(content().contentType("application/json"))
//	.andExpect(jsonPath("$[*]", hasSize(2)))
//	.andExpect(jsonPath("$[0].id").value(101))
//	.andExpect(jsonPath("$[0].address").value("Kolkata"))
//	.andExpect(jsonPath("$[0].name").value("Joy"))
//	.andExpect(jsonPath("$[0].phone").value(900709000));
		
	}
	
	@Test
	void testShowFarmerById() throws Exception {
		Farmer f1=new Farmer(102, "kina@gmail.com", "Kina@1", "kina");
	when(service.getFarmer(102)).thenReturn(f1);
//	mockMvc.perform(get("/farmers/101"))
//	.andExpect(status().isOk())
//	.andExpect(content().contentType("application/json"))
//	.andExpect(jsonPath("$.id").value(101))
//	.andExpect(jsonPath("$.address").value("MI-pro7"))
//	.andExpect(jsonPath("$.name").value("mobile"))
//	.andExpect(jsonPath("$.phone").value(20000));
		
	}
	
	
	@Test
	void testShowFarmerInvalidId() throws Exception {
		Farmer p1=new Farmer(102, "kina@gmail.com", "Kina@1", "kina");
	when(service.getFarmer(101)).thenReturn(p1);
//	MvcResult result=mockMvc.perform(get("/dealers/1"))
//	.andExpect(status().isOk())
//	.andReturn();
//	assertThat(result.getResponse().toString())
//	.as("Dealer with the id 1 doesn't exist");
		
	}
	
	
	@Test
	void testDeleteFarmerById() throws Exception {
		Farmer p1=new Farmer(102, "kina@gmail.com", "Kina@1", "kina");
		String s="deleted successfully....";
	when(service.deleteFarmer(101)).thenReturn(s);
//	mockMvc.perform(delete("/dealers/101"))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));	
	}
	
	@Test
	void testdeleteFarmerInvalidId() throws Exception {
		Farmer d1=new Farmer(102, "kina@gmail.com", "Kina@1", "kina");
		String s="deleted successfully....";
		when(service.deleteFarmer(101)).thenReturn(s);
//	MvcResult result=mockMvc.perform(delete("/farmers/11"))
//	.andExpect(status().isOk())
//	.andReturn();
//	assertThat(result.getResponse().toString())
//	.as("Dealer with the id 1 doesn't exist");
		
	}
	
	@Test
	void testAddFarmer() throws Exception {
		Farmer f1=new Farmer(102, "kina@gmail.com", "Kina@1", "kina");
		String s="added successfully....";
		//when(service.addFarmer(p1)).thenReturn("Added Succesfully");
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter  writer= mapper.writer().withDefaultPrettyPrinter();
		String reqstr= writer.writeValueAsString(f1);
//	mockMvc.perform(post("/farmers/")
//			.contentType("application/json")
//			.content(reqstr))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));
		
	}
	
	@Test
	void testUpdateFarmer() throws Exception {
		Farmer f1=new Farmer(102, "kina@gmail.com", "Kina@1", "kina");
		String s="updated successfully....";
		when(service.updateFarmer(f1)).thenReturn(s);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter  writer= mapper.writer().withDefaultPrettyPrinter();
		String reqstr= writer.writeValueAsString(f1);
//	mockMvc.perform(put("/farmers/")
//			.contentType("application/json")
//			.content(reqstr))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));
		
	}

}
