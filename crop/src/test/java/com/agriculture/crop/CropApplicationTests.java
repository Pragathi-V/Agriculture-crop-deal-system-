package com.agriculture.crop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.agriculture.crop.model.Crop;
import com.agriculture.crop.repo.CropRepository;
import com.agriculture.crop.service.CropServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class CropApplicationTests {
	
	@Test
	 public void contextLoads() {
	}

}
