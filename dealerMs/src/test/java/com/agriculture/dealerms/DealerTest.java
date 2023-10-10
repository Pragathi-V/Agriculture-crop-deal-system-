package com.agriculture.dealerms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.agriculture.dealerms.model.Dealer;

class DealerTest {

	Dealer p1;
	@BeforeEach
	public void before() {
		p1=new Dealer(101,"joyfarm","joyf123","joy@mail.com");
	}
	
	
	@AfterEach
	public void after() {
		p1=null;
	}
	
	@Test
	void testGetId() {
		assertEquals(101, p1.getId());
	}

	@Test	void testGetName() {
		assertEquals("Joy", p1.getName());
	}

	

	@Test
	void testSetId() {
		p1.setId(111);
		//assertEquals(101, p1.getId());
	}

	

	@Test
	void testSetName() {
		p1.setName("Tara");
		assertEquals("Tara", p1.getName());
	}

	
	@Test
	void testSetPassword() {
		p1.setPassword("Taraf1234");
		assertEquals("Taraf1234", p1.getPassword());
	}
	@Test
	void testSetEmail() {
		p1.setEmail("Taraf200@mail.com");
		assertEquals("Taraf200@mail.com", p1.getEmail());
	}
}

