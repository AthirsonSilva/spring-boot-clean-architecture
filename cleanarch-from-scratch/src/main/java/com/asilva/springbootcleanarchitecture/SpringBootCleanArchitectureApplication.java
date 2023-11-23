package com.asilva.springbootcleanarchitecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.httpclient.HttpClientConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableMongoRepositories
@ImportAutoConfiguration({ FeignAutoConfiguration.class, HttpClientConfiguration.class })
public class SpringBootCleanArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCleanArchitectureApplication.class, args);
	}

}
