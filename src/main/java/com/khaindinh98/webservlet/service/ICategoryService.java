package com.khaindinh98.webservlet.service;

import java.util.List;

import com.khaindinh98.webservlet.model.CategoryModel;

public interface ICategoryService {
	
	List<CategoryModel> findAll();
	
	CategoryModel getOne(Long id);
	
	Long insert(CategoryModel categoryModel);
	
	void update(CategoryModel categoryModel);
	
	void delete(Long id);
	
}
