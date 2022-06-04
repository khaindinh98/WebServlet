package com.khaindinh98.webservlet.dao.impl;

import java.util.List;

import com.khaindinh98.webservlet.dao.ICategoryDAO;
import com.khaindinh98.webservlet.mapper.CategoryMapper;
import com.khaindinh98.webservlet.model.CategoryModel;

import javax.inject.Inject;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{

	private CategoryMapper categoryMapper = new CategoryMapper();

	@Override
	public List<CategoryModel> findAll() {
		String query = "SELECT * FROM category";
		return super.executeQuery(categoryMapper, query);
	}

	@Override
	public CategoryModel findOne(Long id) {
		String query = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel> categoryModel = super.executeQuery(categoryMapper, query, id);
		if(categoryModel!=null&&categoryModel.size()!=0) {
			return categoryModel.get(0);
		}
		return null;
	}

	@Override
	public CategoryModel findByCategoryCode(String categoryCode) {
		String query = "SELECT * FROM category WHERE code_category = ?";
		List<CategoryModel> categoryModel = super.executeQuery(categoryMapper, query, categoryCode);
		if(categoryModel!=null&&categoryModel.size()!=0) {
			return categoryModel.get(0);
		}
		return null;
	}

	@Override
	public CategoryModel insert(CategoryModel categoryModel) {
//		String query = "INSERT INTO news (title, content, thumbnail, shortdescription, categoryid, createddate, createdby) VALUES(?, ?, ?, ?, ?, ?, ?)";
		String query = "INSERT INTO category(code_category, name_category, created_at, created_by, modified_at, modified_by) VALUES(?, ?, ?, ?, ?, ?)";
		Long id = super.insert(query, categoryModel.getCode(), categoryModel.getName(), categoryModel.getCreatedAt(), categoryModel.getCreatedBy(), categoryModel.getModifiedAt(), categoryModel.getModifiedBy());
		return findOne(id);
	}

	@Override
	public void update(CategoryModel categoryModel) {
		// TODO Auto-generated method stub
		String query = "UPDATE category SET code_category = ?, name_category = ?, modified_at = ?, modified_by = ? WHERE id = ?";
		super.executeUpdate(query, categoryModel.getCode(), categoryModel.getName(), categoryModel.getModifiedAt(), categoryModel.getModifiedBy(), categoryModel.getId());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM category WHERE id = ?";
		super.executeUpdate(query, id);
	}
	
}
