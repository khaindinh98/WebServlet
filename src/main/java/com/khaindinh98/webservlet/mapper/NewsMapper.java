package com.khaindinh98.webservlet.mapper;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.khaindinh98.webservlet.model.NewsModel;

public class NewsMapper extends AbstractRowMapper<NewsModel> {

	@Override
	public NewsModel mapping(ResultSet resultSet) {
		try {
			NewsModel newsModel = new NewsModel();
			newsModel = mappingDefaultFields(resultSet, newsModel);
			newsModel.setTitle(resultSet.getString("title"));
			newsModel.setShortDescription(resultSet.getString("short_description"));
			newsModel.setContent(resultSet.getString("content"));
			newsModel.setCategoryName(resultSet.getString("name_category"));
			newsModel.setCategoryCode(resultSet.getString("code_category"));
			newsModel.setThumbnail(resultSet.getString("thumbnail"));
			return newsModel;
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
