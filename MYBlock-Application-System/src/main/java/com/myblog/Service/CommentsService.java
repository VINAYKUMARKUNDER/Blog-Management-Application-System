package com.myblog.Service;

import com.myblog.utilDto.CommentsDto;
import com.myblog.utilDto.CommentsDtoAdding;

public interface CommentsService {
	
	CommentsDto createComments(CommentsDtoAdding cDto, Integer userId, Integer postId);
	CommentsDto deleteComments(Integer commentIt);
	

}
