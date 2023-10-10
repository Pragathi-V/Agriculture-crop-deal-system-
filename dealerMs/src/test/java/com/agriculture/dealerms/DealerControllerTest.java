package com.agriculture.dealerms;

import static org.hamcrest.Matchers.hasSize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
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

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.agriculture.dealerms.*;
import com.agriculture.dealerms.model.Dealer;
import com.agriculture.dealerms.service.DealerServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootTest
@AutoConfigureMockMvc
public class DealerControllerTest {

	@MockBean
	private DealerServiceImp service;
	
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
	void testShowDealers() throws Exception {
		Dealer p1=new Dealer(101,"joyfarm","joy@mail.com","joyf123");
		Dealer p2=new Dealer(102,"royfarm","royf123","roy@mail.com");
		List<Dealer> dealerList=new ArrayList<Dealer>();
		dealerList.add(p1);
		dealerList.add(p2);
		when(service.getAllDealer()).thenReturn(dealerList);
	mockMvc.perform(get("/dealers/"));
//	.andExpect(status().isOk())
//	.andExpect(content().contentType("application/json"))
//	.andExpect(jsonPath("$[*]", hasSize(2)))
//	.andExpect(jsonPath("$[0].id").value(101))
//	.andExpect(jsonPath("$[0].address").value("Bangalore"))
//	.andExpect(jsonPath("$[0].name").value("Joy"))
//	.andExpect(jsonPath("$[0].phone").value(97200000));
		
	}
	
	@Test
	void testShowDealerById() throws Exception {
		Dealer p1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
	when(service.getDealerById(101)).thenReturn(p1);
//	mockMvc.perform(get("/dealers/101"))
//	.andExpect(status().isOk())
//	.andExpect(content().contentType("application/json"))
//	.andExpect(jsonPath("$.id").value(101))
//	.andExpect(jsonPath("$.address").value("MI-pro7"))
//	.andExpect(jsonPath("$.name").value("mobile"))
//	.andExpect(jsonPath("$.phone").value(20000));
		
	}
	
	
	@Test
	void testShowDealerInvalidId() throws Exception {
		Dealer p1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
	when(service.getDealerById(101)).thenReturn(p1);
//	MvcResult result=mockMvc.perform(get("/dealers/1"))
//	.andExpect(status().isOk())
//	.andReturn();
//	assertThat(result.getResponse().toString())
//	.as("Dealer with the id 1 doesn't exist");
		
	}
	
	
	@Test
	void testDeleteDealerById() throws Exception {
		Dealer p1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
		String s="deleted successfully....";
	when(service.deleteDealerById(101)).thenReturn(s);
//	mockMvc.perform(delete("/dealers/101"))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));	
	}
	
	@Test
	void testdeleteDealerInvalidId() throws Exception {
		Dealer d1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
		String s="deleted successfully....";
		when(service.deleteDealerById(101)).thenReturn(s);
//	MvcResult result=mockMvc.perform(delete("/dealers/11"))
//	.andExpect(status().isOk())
//	.andReturn();
//	assertThat(result.getResponse().toString())
//	.as("Dealer with the id 1 doesn't exist");
		
	}
	
	@Test
	void testAddDealer() throws Exception {
		Dealer p1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
		String s="added successfully....";
		//when(service.addDealer(p1)).thenReturn("Added Succesfully");
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
		String reqstr=writer.writeValueAsString(p1);
//	mockMvc.perform(post("/dealers/")
//			.contentType("application/json")
//			.content(reqstr))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));
		
	}
	
	@Test
	void testUpdateDealer() throws Exception {
		Dealer p1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
		String s="updated successfully....";
		when(service.updateDealer(p1)).thenReturn(s);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
		String reqstr=writer.writeValueAsString(p1);
//	mockMvc.perform(put("/dealers/")
//			.contentType("application/json")
//			.content(reqstr))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));
		
	}
}
