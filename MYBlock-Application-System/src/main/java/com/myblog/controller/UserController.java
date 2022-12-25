package com.myblog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myblog.Model.User;
import com.myblog.Service.UserService;
import com.myblog.utilDto.UserDto;
import com.myblog.utilDto.userDtoAdding;


@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<UserDto> addUser(@RequestBody userDtoAdding userDto) {
		System.out.println(userDto);
		UserDto users = userService.addUser(userDto);
		return new ResponseEntity<UserDto>(users, HttpStatus.CREATED);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser( @RequestBody userDtoAdding userDto, @PathVariable Integer userId) {
		System.out.println(userDto);
		UserDto users = userService.updateUser(userDto, userId);
		return new ResponseEntity<UserDto>(users, HttpStatus.CREATED);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable Integer userId) {
		UserDto deleteUser = userService.deleteUser(userId);
		return new ResponseEntity<UserDto>(deleteUser, HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer userId) {
		UserDto userById = userService.getUserById(userId);
		return new ResponseEntity<UserDto>(userById, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser() {
		List<UserDto> allUser = userService.getAllUser();
		return new ResponseEntity<List<UserDto>>(allUser, HttpStatus.OK);
	}
	
//	@GetMapping("/email/{email}/")
//	public ResponseEntity<UserDto> getByEmail(@PathVariable String email){
//		UserDto userByEamil = userService.getUserByEamil(email);
//		return new ResponseEntity<UserDto>(userByEamil,HttpStatus.OK);
//	}

}
