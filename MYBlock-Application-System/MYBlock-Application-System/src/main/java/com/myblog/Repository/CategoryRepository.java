package com.myblog.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.myblog.Model.Category;



public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	Category findByCategory(String category);
	

}
