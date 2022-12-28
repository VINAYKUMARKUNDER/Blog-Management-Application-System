package com.myblog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {
	
	@GetMapping("/home/")
	public ResponseEntity<String> home(){
		String msg = "I am home";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	@GetMapping("/login/")
	public ResponseEntity<String> login(){
		String msg = "I am Login";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	@GetMapping("/register/")
	public ResponseEntity<String> register(){
		String msg = "I am register";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

}
