package com.cropdeal.farmer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FarmerMicroservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(FarmerMicroservice1Application.class, args);
	}

}
