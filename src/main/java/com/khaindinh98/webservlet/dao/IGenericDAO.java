package com.khaindinh98.webservlet.dao;

import com.khaindinh98.webservlet.mapper.IRowMapper;

import java.util.List;

public interface IGenericDAO<T> {

	List<T> executeQuery(IRowMapper<T> rowMapper, String query, Object... parameters);

	Long insert(String query, Object... parameters);

	void executeUpdate(String query, Object... parameters);

}
