package com.khaindinh98.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.khaindinh98.dao.impl.NewsDAO;
import com.khaindinh98.model.NewsModel;
import com.khaindinh98.service.INewsService;

public class NewsService implements INewsService{

	@Inject
	private NewsDAO newsDAO;
	
	@Override
	public List<NewsModel> findAll() {
		return newsDAO.findAll();
	}

	@Override
	public NewsModel getOne(Long id) {
		return newsDAO.getOne(id);
	}

	@Override
	public Long insert(NewsModel newsModel) {
		return newsDAO.insert(newsModel);
	}

	@Override
	public void update(NewsModel newsModel) {
		newsDAO.update(newsModel);
	}

	@Override
	public void delete(Long id) {
		newsDAO.delete(id);
	}
	
}
