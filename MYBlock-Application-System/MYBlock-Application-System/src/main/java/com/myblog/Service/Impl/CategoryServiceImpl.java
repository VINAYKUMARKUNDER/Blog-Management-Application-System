package com.myblog.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.Exception.ResponseNotFoundException;
import com.myblog.Model.Category;
import com.myblog.Repository.CategoryRepository;
import com.myblog.Service.CategoryService;
import com.myblog.utilDto.CategoryDto;



@Service
public class CategoryServiceImpl implements CategoryService{
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		Category category = modelMapper.map(categoryDto, Category.class);
		return modelMapper.map(categoryRepository.save(category), CategoryDto.class);
	}
	
	

	@Override
	public CategoryDto deleteCategory(Integer categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResponseNotFoundException("Category", "Category Id", categoryId));
		categoryRepository.delete(category);
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		categoryRepository.findById(categoryId).orElseThrow(()->new ResponseNotFoundException("Category", "category id", categoryId));
		Category updatedCategory = modelMapper.map(categoryDto, Category.class);
		updatedCategory.setCategoryId(categoryId);
		categoryRepository.save(updatedCategory);
		return modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(()->new ResponseNotFoundException("Category", "Category id", categoryId));
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<CategoryDto> allCategoryDtos = categoryRepository.findAll().stream().map(cat-> modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
//		if(allCategoryDtos.size()==0)throw new ResponseNotFoundException(null, null, null);
		
		return allCategoryDtos;
	}
}
