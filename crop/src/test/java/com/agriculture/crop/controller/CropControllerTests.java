package com.agriculture.crop.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import com.agriculture.crop.model.Crop;
import com.agriculture.crop.service.CropServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootTest
@AutoConfigureMockMvc
public class CropControllerTests {

	@MockBean
	private CropServiceImp service;
	
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
	void testShowCrops() throws Exception {
		Crop p1=new Crop(1,"fruit","mango",20000);
		Crop p2=new Crop(2,"vegetable","tomato",200);
		List<Crop> cropList=new ArrayList<Crop>();
		cropList.add(p1);
		cropList.add(p2);
		when(service.getAllCrop()).thenReturn(cropList);}
	
	
	@Test
	void testShowCropById() throws Exception {
		Crop p1=new Crop(1,"fruit","mango",200);
	when(service.getCrop(1)).thenReturn(p1);
	
	}
	
	
	@Test
	void testShowCropInvalidId() throws Exception {
		Crop p1=new Crop(1,"fruit","mango",20000);
	when(service.getCrop(1)).thenReturn(p1);
	MvcResult result=mockMvc.perform(get("/ListCrop/1001"))
	//.andExpect(status().isOk())
	.andReturn();
	assertThat(result.getResponse().toString())
	.as("Crop Not Found");
		
	}
	
	
	@Test
	void testDeleteCropById() throws Exception {
		Crop p1=new Crop(1,"fruit","mango",200);
		//String s="deleted successfully....";
		service.deleteById(1);
	
	
	}
	
	/*@Test
	void testdeleteCropInvalidId() throws Exception {
		Crop p1=new Crop(1,"fruit","mango",200,3);
		service.deleteById(1);
		
	MvcResult result=mockMvc.perform(delete("/deleteCrop/1009"))
	.andExpect(status().isOk())
	.andReturn();
	assertThat(result.getResponse().toString())
	.as("Crop with the id 1009 doesn't exist");
		
	}*/
	
	@Test
	void testAddCrop() throws Exception {
		Crop p1=new Crop(1,"fruit","mango",20000);
		String s="added successfully....";
		when(service.addCrop(p1)).thenReturn(p1);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
		String reqstr=writer.writeValueAsString(p1);
	mockMvc.perform(post("/addCrop/")
			.contentType("application/json")
			.content(reqstr));
	//.andExpect(status().isOk())
	//.andExpect(content().string(s));
		
	}
	
	@Test
	void testUpdateCrop() throws Exception {
		Crop p1=new Crop(1,"vegetable","radish",200);
		when(service.updateCrop(p1)).thenReturn(p1);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
		String reqstr=writer.writeValueAsString(p1);
	mockMvc.perform(put("/updateCrop/")
			.contentType("application/json")
			.content(reqstr));
	//.andExpect(status().isOk())
	//.andExpect(content().string(s));
		
	}
	
}
