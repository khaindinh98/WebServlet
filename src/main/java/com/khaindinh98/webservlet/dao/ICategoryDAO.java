package com.khaindinh98.webservlet.dao;

import java.util.List;

import com.khaindinh98.webservlet.model.CategoryModel;

public interface ICategoryDAO extends IGenericDAO<CategoryModel>{
	
	List<CategoryModel> findAll();
	
	CategoryModel findOne(Long id);

	CategoryModel findByCategoryCode(String categoryCode);

	CategoryModel insert(CategoryModel categoryModel);
	
	void update(CategoryModel categoryModel);
	
	void delete(Long id);
	
}
