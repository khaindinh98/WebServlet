package com.khaindinh98.mapper;

import java.sql.ResultSet;

public interface IRowMapper<T>{
	T mapping(ResultSet resultSet);
}
