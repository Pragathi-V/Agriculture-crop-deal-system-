package com.cropdeal.farmer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cropdeal.farmer.model.Farmer;

public class FarmerModelTest {
	Farmer f1;
	@BeforeEach
	public void before() {
		f1=new Farmer(101,"mirza@gmail.com", "Mirza@1", "mirza");
		f1=new Farmer(102, "kina@gmail.com", "Kina@1", "kina");
		f1=new Farmer(103,"harsh@gmail.com", "Harsh@1", "harsh");
	}
	
	
	@AfterEach
	public void after() {
		f1=null;
	}
	
	@Test
	void testGetId() {
		assertEquals(101, f1.getId());
	}

	@Test
	void testGetName() {
		assertEquals("Mirza", f1.getName());
	}

	
	@Test
	void testGetEmail() {
		assertEquals("mirza@gmail.com", f1.getEmail());
	}

	@Test
	void testGetPassword() {
		assertEquals("Mirza@1", f1.getPassword());
	}
	
	@Test
	void testGetUsername() {
		assertEquals("mirza", f1.getPassword());
	}

	@Test
	void testSetId() {
		f1.setId(101);
		assertEquals(101, f1.getId());
	}

	@Test
	void testSetName() {
		f1.setName("Mirza");
		assertEquals("Mirza", f1.getName());
	}


	@Test
	void testSetEmail() {
		f1.setId(101);
		assertEquals("mirza@gmail.com", f1.getEmail());
	}
	
	

	@Test
	void testSetPassword() {
		f1.setId(101);
		assertEquals("Mirza@1", f1.getPassword());
	}
	
	
	@Test
	void testSetUsername() {
		f1.setId(101);
		assertEquals("mirza", f1.getPassword());
	}



}
