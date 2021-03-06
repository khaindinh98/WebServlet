package com.khaindinh98.service;

import java.util.List;

import com.khaindinh98.model.NewsModel;

public interface INewsService {

	List<NewsModel> findAll();

	NewsModel findOne(Long id);

	NewsModel insert(NewsModel newsModel);

	NewsModel update(NewsModel newsModel);

	void delete(Long[] ids);
	
}
