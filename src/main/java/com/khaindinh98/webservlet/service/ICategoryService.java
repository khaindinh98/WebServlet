package com.khaindinh98.webservlet.service;

import java.util.List;

import com.khaindinh98.webservlet.model.CategoryModel;

public interface ICategoryService {
	
	List<CategoryModel> findAll();
	
	CategoryModel findOne(Long id);

	CategoryModel insert(CategoryModel categoryModel);
	
	void update(CategoryModel categoryModel);
	
	void delete(Long id);

	void delete(Long[] id);

}
