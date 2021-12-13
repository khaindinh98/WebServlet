package com.khaindinh98.dao.impl;

import java.util.List;

import com.khaindinh98.dao.ICategoryDAO;
import com.khaindinh98.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{

	@Override
	public List<CategoryModel> findAll() {
		String query = "SELECT * FROM category";
		return super.executeQuery(query);
	}

	@Override
	public CategoryModel getOne(Long id) {
		String query = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel> categoryModel = super.executeQuery(query, id);
		if(categoryModel!=null&&categoryModel.size()!=0) {
			return categoryModel.get(0);
		}
		return null;
	}

	@Override
	public Long insert(CategoryModel categoryModel) {
//		String query = "INSERT INTO news (title, content, thumbnail, shortdescription, categoryid, createddate, createdby) VALUES(?, ?, ?, ?, ?, ?, ?)";
		String query = "INSERT INTO category(code, name) VALUES(?,?)";
		return super.insert(query, categoryModel.getCode(), categoryModel.getName());
	}

	@Override
	public void update(CategoryModel categoryModel) {
		// TODO Auto-generated method stub
		String query = "UPDATE category SET code = ?, name = ? WHERE id = ?";
		super.executeUpdate(query, categoryModel.getCode(), categoryModel.getName(), categoryModel.getId());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM category WHERE id = ?";
		super.executeUpdate(query, id);
	}
	
}
