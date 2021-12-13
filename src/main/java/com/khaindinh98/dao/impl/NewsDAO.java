package com.khaindinh98.dao.impl;

import java.util.List;

import com.khaindinh98.dao.INewsDAO;
import com.khaindinh98.model.NewsModel;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO{

	@Override
	public List<NewsModel> findAll() {
		String query = "SELECT * FROM news";
		return super.executeQuery(query);
	}

	@Override
	public NewsModel getOne(Long id) {
		String query = "SELECT * FROM news WHERE id = ?";
		List<NewsModel> newsModel = super.executeQuery(query, id);
		if(newsModel!=null&&newsModel.size()!=0) {
			return newsModel.get(0);
		}
		return null;
	}

	@Override
	public Long insert(NewsModel newsModel) {
		String query = "INSERT INTO news (title, content, thumbnail, shortdescription, categoryid, createddate, createdby) VALUES(?, ?, ?, ?, ?, ?, ?)";
		return super.insert(query, newsModel.getTitle(), newsModel.getContent(), newsModel.getThumbnail(), newsModel.getShortDescription(), newsModel.getCategoryId(), newsModel.getCreatedDate(), newsModel.getCreatedBy());
	}

	@Override
	public void update(NewsModel newsModel) {
		String query = "UPDATE news SET title = ?, content = ?, thumbnail = ?, shortdescription = ?, categoryid = ?, createddate = ?, createdby = ? WHERE id = ?";
		super.executeUpdate(query, newsModel.getTitle(), newsModel.getContent(), newsModel.getThumbnail(), newsModel.getShortDescription(), newsModel.getCategoryId(), newsModel.getCreatedDate(), newsModel.getCreatedBy(), newsModel.getId());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM news WHERE id = ?";
		super.executeUpdate(query, id);
	}
	
}
