package com.khaindinh98.webservlet.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.khaindinh98.webservlet.dao.impl.CategoryDAO;
import com.khaindinh98.webservlet.model.CategoryModel;
import com.khaindinh98.webservlet.service.ICategoryService;

public class CategoryService implements ICategoryService{

	@Inject
	private CategoryDAO categoryDAO;
	
	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public CategoryModel findOne(Long id) {
		return categoryDAO.findOne(id);
	}

	@Override
	public CategoryModel insert(CategoryModel categoryModel) {
		return categoryDAO.insert(categoryModel);
	}

	@Override
	public void update(CategoryModel categoryModel) {
		categoryDAO.update(categoryModel);
	}

	@Override
	public void delete(Long id) {
		categoryDAO.delete(id);
	}

	@Override
	public void delete(Long[] ids) {
		for(Long id:ids) {
			categoryDAO.delete(id);
		}
	}
}
