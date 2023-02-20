package com.myblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myblog.Service.CategoryService;
import com.myblog.utilDto.CategoryDto;


@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<CategoryDto> createNewCategory(@RequestBody CategoryDto categoryDto) {
	
		System.out.println(categoryDto);
		CategoryDto newCategoryDto = categoryService.addCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(newCategoryDto, HttpStatus.CREATED);
	}

	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,
			@PathVariable("categoryId") Integer categoryId) {
		CategoryDto updatedCategory = categoryService.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
	}
	
	
	@DeleteMapping ("/{categoryId}")
	public ResponseEntity<CategoryDto> deleteCategory(@PathVariable("categoryId") Integer categoryId){
		CategoryDto deleteCategory = categoryService.deleteCategory(categoryId);
		return new ResponseEntity<CategoryDto>(deleteCategory,HttpStatus.OK);
	}
	
	
	@GetMapping ("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("categoryId") Integer categoryId){
		 CategoryDto categoryById = categoryService.getCategoryById(categoryId);
		return new ResponseEntity<CategoryDto>(categoryById,HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> allCategory = categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(allCategory,HttpStatus.OK);
	}
	
}
