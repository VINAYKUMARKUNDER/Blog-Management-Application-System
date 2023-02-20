package com.myblog.Service;

import java.util.List;

import com.myblog.utilDto.CategoryDto;

public interface CategoryService {
	
	CategoryDto addCategory(CategoryDto categoryDto);
	CategoryDto deleteCategory(Integer categoryId);
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	CategoryDto getCategoryById(Integer categoryId);
	List<CategoryDto> getAllCategory();
	
	

}
