package com.agriculture.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class ApiCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCloudGatewayApplication.class, args);
	}

}
