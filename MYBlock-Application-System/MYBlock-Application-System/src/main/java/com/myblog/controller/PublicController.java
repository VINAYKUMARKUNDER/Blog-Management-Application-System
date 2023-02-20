package com.myblog.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.myblog.Model.User;
import com.myblog.Repository.UserRepository;
import com.myblog.Service.UserService;
import com.myblog.utilDto.UserDto;
import com.myblog.utilDto.userDtoAdding;

@RestController
@RequestMapping("/public")
public class PublicController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private UserService userService;
	
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
	

	
	@GetMapping("/signIn/")
	public ResponseEntity<UserDto>  getLogControllerHandler(Authentication auth){
		System.out.println(auth);
		User user = userRepository.findByEmail(auth.getName()).orElseThrow(()-> new BadCredentialsException("Emial is not found plese put write email.."));
		System.out.println(user);
		
		UserDto map = modelMapper.map(user, UserDto.class);
		return new ResponseEntity<UserDto>(map,HttpStatus.OK);
	}
	
	

	@PostMapping("/register")
	public ResponseEntity<UserDto> addUser(@RequestBody userDtoAdding userDto) {
		userDto.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));
		UserDto users = userService.addUser(userDto);
		return new ResponseEntity<UserDto>(users, HttpStatus.CREATED);
	}

}
