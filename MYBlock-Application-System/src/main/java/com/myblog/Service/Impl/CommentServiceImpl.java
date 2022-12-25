package com.myblog.Service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.Exception.ResponseNotFoundException;
import com.myblog.Model.Comments;
import com.myblog.Model.Post;
import com.myblog.Model.User;
import com.myblog.Repository.CommentsRepository;
import com.myblog.Repository.PostRepository;
import com.myblog.Repository.UserRepository;
import com.myblog.Service.CommentsService;
import com.myblog.utilDto.CommentsDto;
import com.myblog.utilDto.CommentsDtoAdding;

@Service
public class CommentServiceImpl implements CommentsService {
	
	@Autowired
	private CommentsRepository commentsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentsDto createComments(CommentsDtoAdding cDto, Integer userId, Integer postId) {
//		User user = userRepository.findById(userId).orElseThrow(()-> new ResponseNotFoundException("User ", "User Id", userId));
//		Post post = postRepository.findById(postId).orElseThrow(()-> new ResponseNotFoundException("Post", "post Id", userId));
//		Comments comments = modelMapper.map(cDto, Comments.class);
//		comments.setPost(post);
//		commentsRepository.save(comments);
//		
//		return modelMapper.map(comments, CommentsDto.class);
		return null;
	}

	@Override
	public CommentsDto deleteComments(Integer commentIt) {
		// TODO Auto-generated method stub
		return null;
	}

}
