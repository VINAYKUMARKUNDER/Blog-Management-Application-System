package com.myblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myblog.Service.PostService;
import com.myblog.config.BlogConstent;
import com.myblog.utilDto.PageResponse;
import com.myblog.utilDto.PostDto;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("/user/{userId}/category/{categoryId}/post")
	public ResponseEntity<PostDto> createPost(@PathVariable Integer userId, @PathVariable Integer categoryId,
			@RequestBody PostDto postDto) {

		PostDto addPost = postService.addPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(addPost, HttpStatus.CREATED);
	}

	@GetMapping("/posts/{keyword}")
	public ResponseEntity<List<PostDto>> searchByTitle(@PathVariable("keyword") String postTitle) {
		List<PostDto> searchAllPostByTitle = postService.searchPost(postTitle);
		return new ResponseEntity<List<PostDto>>(searchAllPostByTitle, HttpStatus.OK);
	}

	@GetMapping("/post/")
	public ResponseEntity<PageResponse> getAllPosts(
			@RequestParam(value = "pageNumber", defaultValue = BlogConstent.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = BlogConstent.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = BlogConstent.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDirection", defaultValue = BlogConstent.SORT_DIRECTION, required = false) String sortDirection) {
		PageResponse allPost = postService.getAllPost(pageNumber, pageSize, sortBy, sortDirection);
		return new ResponseEntity<PageResponse>(allPost, HttpStatus.OK);
	}

	@DeleteMapping("/post/{postId}")
	public ResponseEntity<PostDto> deletePost(@PathVariable Integer postId) {
		PostDto deletePost = postService.deletePost(postId);
		return new ResponseEntity<PostDto>(deletePost, HttpStatus.OK);
	}

	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getOnePost(@PathVariable Integer postId) {
		PostDto post = postService.getPost(postId);
		return new ResponseEntity<PostDto>(post, HttpStatus.OK);
	}

	@GetMapping("/category/{category}/post/")
	public ResponseEntity<PageResponse> getAllPostCategory(@PathVariable("category") String category,
			@RequestParam(value = "pageNumber", defaultValue = BlogConstent.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = BlogConstent.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = BlogConstent.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDirection", defaultValue = BlogConstent.SORT_DIRECTION, required = false) String sortDirection) {
		PageResponse allPostByCategory = postService.getAllPostByCategory(category, pageNumber, pageSize, sortBy,
				sortBy);
		return new ResponseEntity<PageResponse>(allPostByCategory, HttpStatus.OK);
	}
	
	
	@GetMapping("/user/{userId}/post/")
	public ResponseEntity<List<PostDto>> getAllPostByUserId(@PathVariable Integer userId){
		List<PostDto> allPostByUserId = postService.getAllPostByUserId(userId);
		return new ResponseEntity<List<PostDto>>(allPostByUserId,HttpStatus.OK);
	}
	
	
	@GetMapping("/posts/{postTitle}/")
	public ResponseEntity<List<PostDto>>  getAllPostByTitle(@PathVariable String postTitle){
		List<PostDto> searchAllPostByTitle = postService.searchAllPostByTitle(postTitle);
		return new ResponseEntity<List<PostDto>>(searchAllPostByTitle,HttpStatus.OK);
	}

}
