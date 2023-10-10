package com.agriculture.crop.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CropTest {

	Crop p1;
	@BeforeEach
	public void before() {
		p1=new Crop(101, "vegetable", "tomato", 100);
	}
	
	
	@AfterEach
	public void after() {
		p1=null;
	}
	
	@Test
	void testGetId() {
		assertEquals(101, p1.getId());
	}

	@Test
	void testGetName() {
		assertEquals("tomato", p1.getName());
	}

	@Test
	void testGetType() {
		assertEquals("vegetable", p1.getType());
	}

	@Test
	void testGetPrice() {
		assertEquals(100, p1.getPrice());
	}

	
	@Test
	void testSetId() {
		p1.setId(111);
	}

	@Test
	void testSetName() {
		p1.setName("tomato");
		assertEquals("tomato", p1.getName());
	}

	@Test
	void testSetType() {
		p1.setType("vegetable");
		assertEquals("vegetable", p1.getType());
	}

	@Test
	void testSetPrice() {
		p1.setPrice(100);
		assertEquals(100, p1.getPrice());
	}

	

}