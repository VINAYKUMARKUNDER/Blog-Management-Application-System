package com.myblog.utilDto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentsDto {

	private Integer commentId;
	private String comment;
	private UserDto users;
	
}
