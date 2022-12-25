package com.myblog.utilDto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PostDto {
	
	private Integer postId;
	private String postTitle;
	private String content;
	private String postImage;
	private LocalDate date;

	private UserDto users;
	
	private CategoryDto category;


}
