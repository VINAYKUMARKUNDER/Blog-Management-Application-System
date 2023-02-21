package com.myblog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		servers = {
		@Server(url = "/", description = "Default Server URL")
		}
		)


@SpringBootApplication
public class MyBlockApplicationSystemApplication {
	
	
	

	public static void main(String[] args) {
		
		
		
		SpringApplication.run(MyBlockApplicationSystemApplication.class, args);
		
		
	}
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	



}
