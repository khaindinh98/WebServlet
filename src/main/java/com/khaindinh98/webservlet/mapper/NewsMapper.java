package com.khaindinh98.webservlet.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.khaindinh98.webservlet.model.NewsModel;

public class NewsMapper implements IRowMapper<NewsModel>{

	@Override
	public NewsModel mapping(ResultSet resultSet) {
		try {
			NewsModel news = new NewsModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryName(resultSet.getString("name"));
			news.setCategoryCode(resultSet.getString("code"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			if(resultSet.getTimestamp("createddate")!=null) {
				news.setCreatedAt(resultSet.getTimestamp("createddate").toLocalDateTime());
			}
			news.setCreatedBy(resultSet.getString("createdby"));
			if(resultSet.getTimestamp("modifieddate")!=null) {
				news.setModifiedAt(resultSet.getTimestamp("modifieddate").toLocalDateTime());
			}
			news.setModifiedBy(resultSet.getString("modifiedby"));
			return news;
		} catch (SQLException e) {
			return null;
		}	
	}

}
