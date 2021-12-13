package com.khaindinh98.dao;

import java.util.List;

public interface IGenericDAO<T> {

	List<T> executeQuery(String query, Object... parameters);

	Long insert(String query, Object... parameters);

	void executeUpdate(String query, Object... parameters);


}
