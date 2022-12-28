package com.myblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myblog.Service.CommentsService;
import com.myblog.utilDto.CommentsDto;
import com.myblog.utilDto.CommentsDtoAdding;

@RestController
@RequestMapping("/api/")
public class CommentsController {

	@Autowired
	private CommentsService commentsService;

	@PostMapping("/user/{userId}/post/{postId}/comment/")
	public ResponseEntity<CommentsDto> createNewComments(@RequestBody CommentsDtoAdding cDto,
			@PathVariable("userId") Integer userId, @PathVariable("postId") Integer postId) {
		CommentsDto createComments = commentsService.createComments(cDto, userId, postId);
		return new ResponseEntity<CommentsDto>(createComments, HttpStatus.CREATED);
	}

}
