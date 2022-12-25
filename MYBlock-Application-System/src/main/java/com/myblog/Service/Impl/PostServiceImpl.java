package com.myblog.Service.Impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myblog.Exception.ResponseNotFoundException;
import com.myblog.Model.Category;
import com.myblog.Model.Post;
import com.myblog.Model.User;
import com.myblog.Repository.CategoryRepository;
import com.myblog.Repository.PostRepository;
import com.myblog.Repository.UserRepository;
import com.myblog.Service.PostService;
import com.myblog.utilDto.CategoryDto;
import com.myblog.utilDto.PageResponse;
import com.myblog.utilDto.PostDto;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDto addPost(PostDto postDto, Integer userId, Integer categoryId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResponseNotFoundException("User", "user id", userId));
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResponseNotFoundException("Category", "category id", categoryId));

		Post post = modelMapper.map(postDto, Post.class);
		System.out.println(user);
		post.setUsers(user);
		post.setCategory(category);
		post.setDate(LocalDate.now());
		postRepository.save(post);
		System.out.println(user);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		postRepository.findById(postId).orElseThrow(() -> new ResponseNotFoundException("Post", "Post Id", postId));
		Post post = modelMapper.map(postDto, Post.class);
		post.setPostId(postId);
		postRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto deletePost(Integer postId) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResponseNotFoundException("Post", "post Id", postId));
		postRepository.delete(post);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto getPost(Integer postId) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResponseNotFoundException("Post", "post id", postId));
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PageResponse getAllPost(Integer pageNumber, Integer pageSize,String sort, String sortDirection) {
	Sort sortInfo=	(sortDirection.equalsIgnoreCase("asc")) ? Sort.by(sort).ascending() : Sort.by(sort).descending();
		
		Pageable page= PageRequest.of(pageNumber, pageSize,sortInfo);
		 Page<Post> findAll = postRepository.findAll(page);
		 List<Post> posts = findAll.getContent();
		List<PostDto> allPosts =posts.stream().map(post -> modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		
		PageResponse pageResponse= new PageResponse();
		pageResponse.setContent(allPosts);
		pageResponse.setPageNumber(findAll.getNumber());
		pageResponse.setPageSize(findAll.getSize());
		pageResponse.setTotalElement(findAll.getNumberOfElements());
		pageResponse.setPageStatus(findAll.isLast());
		pageResponse.setTotalPage(findAll.getTotalPages());
		return pageResponse;
	}
	
	
	

	@Override
	public PageResponse getAllPostByCategory(String category,Integer pageNumber, Integer pageSize,String sort, String sortDirection) {
      Category findByCategory = categoryRepository.findByCategory(category);
		
		Sort sortInfo=	(sortDirection.equalsIgnoreCase("asc")) ? Sort.by(sort).ascending() : Sort.by(sort).descending();
		Pageable page= PageRequest.of(pageNumber, pageSize,sortInfo);
		
	
			 List<Post> allPost = postRepository.findByCategory(findByCategory,page);
		Page<Post> findAll = postRepository.findAll(page);
		List<PostDto> allPosts =allPost.stream().map(post -> modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		
		PageResponse pageResponse= new PageResponse();
		pageResponse.setContent(allPosts);
		pageResponse.setPageNumber(findAll.getNumber());
		pageResponse.setPageSize(findAll.getSize());
		pageResponse.setTotalElement(findAll.getNumberOfElements());
		pageResponse.setPageStatus(findAll.isLast());
		pageResponse.setTotalPage(findAll.getTotalPages());
		return pageResponse;
	}

	@Override
	public List<PostDto> getAllPostByUserId(Integer usreId) {
		User user = userRepository.findById(usreId)
				.orElseThrow(() -> new ResponseNotFoundException("User", "user id", usreId));
		List<PostDto> allPosts = postRepository.findByUsers(user).stream()
				.map(post -> modelMapper.map(user, PostDto.class)).collect(Collectors.toList());
		return allPosts;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		System.out.println(keyword);
		List<PostDto> listOfPosts = postRepository.findByPostContent("%"+keyword+"%").stream()
				.map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return listOfPosts;
	}

	@Override
	public List<PostDto> searchAllPostByTitle(String title) {
		List<Post> findByPostTitle = postRepository.findByPostTitle("%"+title+"%");
		List<PostDto> collect = findByPostTitle.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return collect;
	}

}
