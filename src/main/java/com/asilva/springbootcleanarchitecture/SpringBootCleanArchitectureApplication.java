package com.asilva.springbootcleanarchitecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootCleanArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCleanArchitectureApplication.class, args);
	}

}
