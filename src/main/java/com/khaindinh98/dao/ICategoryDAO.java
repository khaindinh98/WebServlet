package com.khaindinh98.dao;

import java.util.List;

import com.khaindinh98.model.CategoryModel;

public interface ICategoryDAO extends IGenericDAO<CategoryModel>{
	
	List<CategoryModel> findAll();
	
	CategoryModel getOne(Long id);
	
	Long insert(CategoryModel categoryModel);
	
	void update(CategoryModel categoryModel);
	
	void delete(Long id);
	
}
