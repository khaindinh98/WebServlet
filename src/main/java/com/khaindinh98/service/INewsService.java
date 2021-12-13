package com.khaindinh98.service;

import java.util.List;

import com.khaindinh98.model.NewsModel;

public interface INewsService {

	List<NewsModel> findAll();

	NewsModel getOne(Long id);

	Long insert(NewsModel newsModel);

	void update(NewsModel newsModel);

	void delete(Long id);
	
}
