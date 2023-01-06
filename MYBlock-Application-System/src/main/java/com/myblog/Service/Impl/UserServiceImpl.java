package com.myblog.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myblog.Exception.ResponseNotFoundException;
import com.myblog.Model.User;
import com.myblog.Repository.UserRepository;
import com.myblog.Service.UserService;
import com.myblog.utilDto.UserDto;
import com.myblog.utilDto.userDtoAdding;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto addUser(userDtoAdding userDto) {
		User user = modelMapper.map(userDto, User.class);
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		userRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUser(userDtoAdding userDto, Integer userId) {
		userRepository.findById(userId).orElseThrow(() -> new ResponseNotFoundException("User", "User Id", userId));
		User user = modelMapper.map(userDto, User.class);
		user.setUserId(userId);
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		userRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto deleteUser(Integer userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResponseNotFoundException("User", "user id", userId));
		userRepository.delete(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResponseNotFoundException("User", "user id", userId));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<UserDto> allUserDetos = userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return allUserDetos;
	}


}
