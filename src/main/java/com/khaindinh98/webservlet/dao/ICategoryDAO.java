package com.khaindinh98.webservlet.dao;

import java.util.List;

import com.khaindinh98.webservlet.model.CategoryModel;

public interface ICategoryDAO extends IGenericDAO<CategoryModel>{
	
	List<CategoryModel> findAll();
	
	CategoryModel getOne(Long id);

	CategoryModel findByCategoryCode(String categoryCode);

	Long insert(CategoryModel categoryModel);
	
	void update(CategoryModel categoryModel);
	
	void delete(Long id);
	
}
