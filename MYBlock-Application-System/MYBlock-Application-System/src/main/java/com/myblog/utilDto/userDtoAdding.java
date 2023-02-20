package com.myblog.utilDto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;


@Data
public class userDtoAdding {
	private Integer userId;
	
	@Size(min = 3 , max = 100, message = "Name should be min 3 and max 100 character..")
	@NotNull
	private String userName;
	
	@Column(unique = true)
	@Email
	private String userEmail;
	
	@NotNull
//	@Size(min = 5, max = 10, message = "Password should be min 5 char and max 10 char")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String userPassword;
	
	@NotNull(message = "plese put about max 100 char charecter..")
	private String about;


}
