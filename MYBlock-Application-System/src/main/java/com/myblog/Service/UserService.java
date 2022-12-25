package com.myblog.Service;

import java.util.List;

import com.myblog.Model.User;
import com.myblog.utilDto.UserDto;
import com.myblog.utilDto.userDtoAdding;

public interface UserService {
	public UserDto addUser(userDtoAdding userDto);
	public UserDto updateUser(userDtoAdding userDto,Integer userId);
	public UserDto deleteUser(Integer userId);
	public UserDto getUserById(Integer userId);
	List<UserDto> getAllUser();
//	UserDto getUserByEamil(String email);
	
	String addRoll(Integer rollId, Integer userId);
	
	
}
