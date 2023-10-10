//package com.agriculture.authentication.models;
//
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document(collection = "Farmer")
//public class Farmer {
//
//	public static final String SEQUENCE_NAME = "farmer_sequence";
//	@Id
//	private int id;
//	
//	@NotEmpty
//    @Pattern(regexp = "^[A-Za-z -]+$",message = "farmer address required Only alphabets and - allowed")
//   //@Size(min = 3, max = 20,message = "min 3 max 20")
//	private String address;
//	
//	
//	@NotEmpty
//    @Pattern(regexp = "^[A-Za-z -]+$",message =" farmer name required Only alphabets and - allowed")
//  // @Size(min = 3, max = 20,message = "min 3 max 20")
//	private String name;
//	
//	
//	@NotNull
//	//@Size(max = 10)
//	private long phone;
//
//
//	public Farmer() {
//		super();
//	}
//
//
//	public Farmer(int id,
//			String address,
//			String name,
//		    long phone) {
//		super();
//		this.id = id;
//		this.address = address;
//		this.name = name;
//		this.phone = phone;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Dealer [id=" + id + ", address=" + address + ", name=" + name + ", phone=" + phone + "]";
//	}
//
//
//	public int getId() {
//		return id;
//	}
//
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//
//	public String getAddress() {
//		return address;
//	}
//
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//
//	public String getName() {
//		return name;
//	}
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public long getPhone() {
//		return phone;
//	}
//
//
//	public void setPhone(long phone) {
//		this.phone = phone;
//	}
//	
//}

package com.agriculture.authentication.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Farmer")
public class Farmer {

	public static final String SEQUENCE_NAME = "farmer_sequence";
	@Id
	private int id;
	
	/*
	 * @NotEmpty
	 * 
	 * @Pattern(regexp = "^[A-Za-z -]+$",message =
	 * "farmer address required Only alphabets and - allowed") //@Size(min = 3, max
	 * = 20,message = "min 3 max 20") private String address;
	 */
	
	
	@NotEmpty
    @Pattern(regexp = "^[A-Za-z -]+$",message =" farmer name required Only alphabets and - allowed")
  // @Size(min = 3, max = 20,message = "min 3 max 20")
	private String name;
	
	/*
	 * @NotNull //@Size(max = 10) private long phone;
	 */
	
	@NotNull
	private String email;
	
	@NotNull
	//@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()â€“[{}]:;',?/*~$^+=<>]).{8,20}$")
	private String password;
	
	/*
	 * @NotNull private String username;
	 */
	
	public Farmer() {
		super();
	}

	public Farmer(int id,
			@NotEmpty @Pattern(regexp = "^[A-Za-z -]+$", message = " farmer name required Only alphabets and - allowed") String name,
			 @NotNull String email,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
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


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}



	@Override
	public String toString() {
		return "Farmer [id=" + id + ", name=" + name + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
}



	
