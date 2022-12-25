package com.myblog.utilDto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.myblog.Model.Post;
import com.myblog.Model.User;

import lombok.Data;

@Data
public class CommentsDto {

	private Integer commentId;
	private String comment;
	
	private Post post;
	
	private List<User> users = new ArrayList<>();
}
