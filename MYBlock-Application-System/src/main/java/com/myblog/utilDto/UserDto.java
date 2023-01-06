package com.myblog.utilDto;

import lombok.Data;

@Data
public class UserDto {
	
	private Integer userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String about;
	private String role;

}
