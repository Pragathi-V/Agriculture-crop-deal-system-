package com.agriculture.dealerms.model;

import javax.validation.constraints.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Dealer")
public class Dealer {

	public static final String SEQUENCE_NAME = "dealer_sequence";
	@Id
	private int id;
	
//	@NotEmpty
//    @Pattern(regexp = "^[A-Za-z -]+$",message = "dealer address required Only alphabets and - allowed")
//   //@Size(min = 3, max = 20,message = "min 3 max 20")
//	private String address;
//	
	
	@NotEmpty
   @Pattern(regexp = "^[A-Za-z -]+$",message =" dealer name required Only alphabets and - allowed")
  //@Size(min = 3, max = 20,message = "min 3 max 20")
	private String name;
	
//	@NotEmpty
//	   @Pattern(regexp = "^[A-Za-z -]+$",message =" dealer name required Only alphabets and - allowed")
//	  //@Size(min = 3, max = 20,message = "min 3 max 20")
//	private String username;
	
	private String email;
	private String password;

//	@NotNull
//	//@Size(max = 10)
//	private long phone;


	public Dealer() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}


	@Override
	public String toString() {
		return "Dealer [id=" + id + ", name=" + name + ", "
				+ " password=" + password + ", email=" + email +  "]";
	}


	public Dealer(int id,  String name,String email,String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;

	}


}	