package com.khaindinh98.webservlet.service;

import java.util.List;

import com.khaindinh98.webservlet.model.NewsModel;

public interface INewsService {

	List<NewsModel> findAll();

	NewsModel findOne(Long id);

	NewsModel insert(NewsModel newsModel);

	NewsModel update(NewsModel newsModel);

	void delete(Long[] ids);
	
}
