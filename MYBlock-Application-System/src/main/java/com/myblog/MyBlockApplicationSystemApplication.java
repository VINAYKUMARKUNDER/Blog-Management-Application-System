package com.myblog;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.myblog.Service.Impl.UserServiceImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class MyBlockApplicationSystemApplication implements CommandLineRunner{
	

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		
		SpringApplication.run(MyBlockApplicationSystemApplication.class, args);
		
	}
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println(passwordEncoder.encode("xyz"));
		
	}

}
