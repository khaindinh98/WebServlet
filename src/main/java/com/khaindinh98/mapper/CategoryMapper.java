package com.khaindinh98.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.khaindinh98.model.CategoryModel;

public class CategoryMapper implements IRowMapper<CategoryModel>{

	@Override
	public CategoryModel mapping(ResultSet resultSet) {
		try {
			CategoryModel category = new CategoryModel();
			category.setId(resultSet.getLong("id"));
			category.setCode(resultSet.getString("code"));
			category.setName(resultSet.getString("name"));
			return category;
		} catch (SQLException e) {
			return null;
		}
	}

}
