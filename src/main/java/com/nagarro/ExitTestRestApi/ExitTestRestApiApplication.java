package com.nagarro.ExitTestRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.nagarro.ExitTestRestApi.model")
public class ExitTestRestApiApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(ExitTestRestApiApplication.class, args);
	}
}
