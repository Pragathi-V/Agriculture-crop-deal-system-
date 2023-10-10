package com.agriculture.dealerms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DealermsMsApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DealermsMsApplication.class, args);
	}

}
