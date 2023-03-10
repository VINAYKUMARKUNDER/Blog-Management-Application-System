package com.myblog.utilDto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.myblog.Model.Comments;
import com.myblog.Model.Post;
import com.myblog.Model.Role;

import lombok.Data;

@Data
public class UserDto {
	
	private Integer userId;
	private String userName;
	private String userEmail;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String userPassword;
	private String about;
	
//	private List<Post> posts = new ArrayList<>();
//	private List<Comments> comments = new ArrayList<>();
//	private List<Role> role = new ArrayList<>();

}
