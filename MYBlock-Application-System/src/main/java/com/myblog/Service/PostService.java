package com.myblog.Service;

import java.util.List;

import com.myblog.utilDto.PageResponse;
import com.myblog.utilDto.PostDto;

public interface PostService {
	
	PostDto addPost(PostDto postDto,Integer userId, Integer categoryId);
	PostDto updatePost(PostDto postDto,Integer postId);
	PostDto deletePost(Integer postId);
	PostDto getPost(Integer postId);
	PageResponse getAllPost(Integer pageNumber, Integer pageSize,String sort, String sortDirection);
	PageResponse getAllPostByCategory(String category,Integer pageNumber, Integer pageSize,String sort, String sortDirection);
	List<PostDto> getAllPostByUserId(Integer usreId);
	List<PostDto> searchPost(String keyword);
	List<PostDto>  searchAllPostByTitle(String title);

}
