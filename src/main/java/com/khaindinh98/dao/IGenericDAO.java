package com.khaindinh98.dao;

import com.khaindinh98.mapper.IRowMapper;

import java.util.List;

public interface IGenericDAO<T> {

	List<T> executeQuery(IRowMapper<T> rowMapper, String query, Object... parameters);

	Long insert(String query, Object... parameters);

	void executeUpdate(String query, Object... parameters);


}
