package com.khaindinh98.webservlet.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.khaindinh98.webservlet.dao.impl.NewsDAO;
import com.khaindinh98.webservlet.model.NewsModel;
import com.khaindinh98.webservlet.service.INewsService;

public class NewsService implements INewsService {

	@Inject
	private NewsDAO newsDAO;
	
	@Override
	public List<NewsModel> findAll() {
		return newsDAO.findAll();
	}

	@Override
	public NewsModel findOne(Long id) {
		return newsDAO.findOne(id);
	}

	@Override
	public NewsModel insert(NewsModel newsModel) {
		Long id = newsDAO.insert(newsModel);
		return newsDAO.findOne(id);
	}

	@Override
	public NewsModel update(NewsModel updateNewsModel) {
		newsDAO.update(updateNewsModel);
		return newsDAO.findOne(updateNewsModel.getId());
	}

	@Override
	public void delete(Long[] ids) {
		for(Long id:ids) {
			newsDAO.delete(id);
		}
	}
	
}
