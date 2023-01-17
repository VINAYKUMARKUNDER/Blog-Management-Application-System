package com.myblog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class MyBlockApplicationSystemApplication {
	

	public static void main(String[] args) {
		
		SpringApplication.run(MyBlockApplicationSystemApplication.class, args);
		
	}
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


}
