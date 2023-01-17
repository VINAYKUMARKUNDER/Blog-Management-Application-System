package com.myblog.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myblog.Model.Category;
import com.myblog.Model.Post;
import com.myblog.Model.User;

public interface PostRepository extends JpaRepository<Post, Integer>{
	List<Post> findByCategory(Category category,Pageable page);
	
	
//	@Query(value =  "from Post where content LIKE '%India%'") // Working..
//	@Query(value =  "from Post where content LIKE '%?1%'")  // Not Working
//	@Query(value =  "from Post where content LIKE '%:name%'") // Not Working.. 
//	@Query(value =  " from Post where content LIKE '%India%'",nativeQuery = true)// Not Working..

	@Query(value =  "from Post where content LIKE ?1")
		List<Post> findByPostContent(String keyword);
	
	
	
	
	List<Post> findByContent(String content);
	
	@Query(value =  "from Post where postTitle LIKE ?1")
	List<Post> findByPostTitle(String postTitle);
	List<Post> findByUsers(User users);
	

}
