package com.agriculture.crop.model;

import javax.validation.constraints.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;


@Document(collection = "Crop")
public class Crop {

	public static final String SEQUENCE_NAME = "crop_sequence";
	@Id
	private int id;
	
	@NotEmpty
    @Pattern(regexp = "^[A-Za-z -]+$",message = "crop type required !! Only alphabets and - allowed")
   //@Size(min = 3, max = 20,message = "min 3 max 20")
	@ApiModelProperty(notes="Type of crop",name="type",required=true,value="vegetable")
	private String type;
	
	
	@NotEmpty
    @Pattern(regexp = "^[A-Za-z -]+$",message =" crop name required !! Only alphabets and - allowed")
  // @Size(min = 3, max = 20,message = "min 3 max 20")
	@ApiModelProperty(notes="name of crop",name="name",required=true,value="tomato")
	private String name;
	
	
	@NotNull
	@Digits(fraction = 0, integer = 5)
	@ApiModelProperty(notes="price of crop per kg",name="price",required=true,value="700")

	private int price;
	


	public Crop( int id,String type, String name, int price) {
		super();
		this.id=id;
		this.type = type;
		this.name = name;
		this.price = price;

	}

	@Override
	public String toString() {
		return "Crop [id=" + id + ", type=" + type + ", name=" + name + ", price=" + price + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
