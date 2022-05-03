package com.khaindinh98.webservlet.mapper;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.khaindinh98.webservlet.model.CategoryModel;

public class CategoryMapper extends AbstractRowMapper<CategoryModel> {

	@Override
	public CategoryModel mapping(ResultSet resultSet) {
		try {
			CategoryModel categoryModel = new CategoryModel();
			categoryModel = mappingDefaultFields(resultSet, categoryModel);
			categoryModel.setName(resultSet.getString("name_category"));
			categoryModel.setCode(resultSet.getString("code_category"));
			return categoryModel;
		} catch (SQLException e) {
			return null;
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

}
