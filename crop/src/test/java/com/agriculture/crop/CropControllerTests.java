/*package com.agriculture.crop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.agriculture.crop.model.Crop;
import com.agriculture.crop.repo.CropRepository;
import com.agriculture.crop.service.CropServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CropControllerTests.class)
class CropControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private  CropServiceImp cropServiceimpl;
	

	@MockBean
	private CropRepository customerRepository;
	
    @Test
   public  List<Crop> getAllCrop() throws Exception{
    	List<Crop> crop= new ArrayList<>();
    	crop.add(new Crop(1,"vegetable","tomato",900,2));
    	crop.add(new Crop(2,"fruit","mango",1000,1));
    	Mockito.when(cropServiceimpl.getAllCrop());
    	
    	String url ="crop/ListCrop";
  MvcResult mvcResult=  mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
  String actualJsonResponse=mvcResult.getResponse().getContentAsString();
  System.out.println(actualJsonResponse);
  String exceptedJsonResponse = objectMapper.writeValueAsString(crop);
  assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(exceptedJsonResponse);
	return crop;
    	
    }
}
*/