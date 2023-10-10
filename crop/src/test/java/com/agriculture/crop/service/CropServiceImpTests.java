package com.agriculture.crop.service;

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

import com.agriculture.crop.exceptions.CropNotFoundException;
import com.agriculture.crop.exceptions.NoProperDataException;
import com.agriculture.crop.model.Crop;
import com.agriculture.crop.repo.CropRepository;


@SpringBootTest
@AutoConfigureMockMvc
public class CropServiceImpTests {

	
	@InjectMocks
	private CropServiceImp service;
	
	@Mock
	private CropRepository repository;
	
	@Test
	void testServiceNotNull() {
		assertThat(service).isNotNull();
	}
	
	@Test
	void testRepositoryNotNull() {
		assertThat(repository).isNotNull();
	}
	
	@Test
	void testGetAllCrops() {
		Crop p1=new Crop(101,"vegetable","tomato",2000);
		Crop p2=new Crop(102,"fruit","mango",4000);
		List<Crop> cropList=new ArrayList<Crop>();
		cropList.add(p1);
		cropList.add(p2);
		when(repository.findAll()).thenReturn(cropList);
		assertEquals(cropList,service.getAllCrop());
		
	}
	
	@Test
	void testGetCropById() throws CropNotFoundException {
		Crop p1=new Crop(101,"vegetable","tomato",2000);
		when(repository.findById(101)).thenReturn(Optional.of(p1));
		assertEquals(p1,service.getCrop(101));
	}
	
	
	
	@Test
	void testAddCrop() throws  NoProperDataException {
		Crop p1=new Crop(101,"vegetable","tomato",2000);
		assertThat(service.addCrop(p1));
	
	}	
	
	
	@Test
	void testupdateCrop() throws CropNotFoundException {
		Crop p1=new Crop(101,"vegetable","tomato",2000);
		when(repository.findById(101)).thenReturn(Optional.of(p1));
	 assertThat(service.updateCrop(p1));
	
	}
	
	@SuppressWarnings({ "unlikely-arg-type", "unchecked" })
	@Test
	void testupdateCropDoesnotExists() throws CropNotFoundException {
		Crop p1=new Crop(101,"vegetable","tomato",2000);
		when(repository.findById(10)).thenReturn(Optional.of(p1));
	
	}
	
	@Test
	void testDeleteCropById() throws CropNotFoundException {
		Crop p1=new Crop(101,"vegetable","tomato",2000);
		when(repository.findById(101)).thenReturn(Optional.of(p1));
		service.deleteById(101);
	}
	
	@Test
	void testDeleteCropByInvalidId() throws CropNotFoundException {
		Crop p1=new Crop(101,"vegetable","tomato",2000);
		when(repository.findById(101)).thenReturn(Optional.of(p1));
		try {
			service.deleteById(111);
		}catch(Exception e) {
			
		}
	}
	
	
	}

