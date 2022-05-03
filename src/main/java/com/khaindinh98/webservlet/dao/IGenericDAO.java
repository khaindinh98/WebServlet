package com.khaindinh98.webservlet.dao;

import com.khaindinh98.webservlet.mapper.AbstractRowMapper;
import com.khaindinh98.webservlet.model.AbstractModel;

import java.util.List;

public interface IGenericDAO<T extends AbstractModel> {

	List<T> executeQuery(AbstractRowMapper<T> abstractRowMapper, String query, Object... parameters);

	Long insert(String query, Object... parameters);

	void executeUpdate(String query, Object... parameters);

}
