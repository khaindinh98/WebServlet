package com.khaindinh98.webservlet.dao;

import java.util.List;

import com.khaindinh98.webservlet.model.NewsModel;

public interface INewsDAO extends IGenericDAO<NewsModel>{
	
	List<NewsModel> findAll();
	
	NewsModel findOne(Long id);
	
	Long insert(NewsModel newsModel);
	
	void update(NewsModel newsModel);
	
	void delete(Long id);
	
}
