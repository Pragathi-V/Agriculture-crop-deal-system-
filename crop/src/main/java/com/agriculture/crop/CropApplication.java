package com.agriculture.crop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication

public class CropApplication {

	public static void main(String[] args)  {
		SpringApplication.run(CropApplication.class, args);
	}

	
}
