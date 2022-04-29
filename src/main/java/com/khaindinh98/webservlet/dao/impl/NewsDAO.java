package com.khaindinh98.webservlet.dao.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.khaindinh98.webservlet.dao.INewsDAO;
import com.khaindinh98.webservlet.mapper.NewsMapper;
import com.khaindinh98.webservlet.model.CategoryModel;
import com.khaindinh98.webservlet.model.NewsModel;
import com.khaindinh98.webservlet.service.impl.CategoryService;

import javax.inject.Inject;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO{

	@Inject
	private NewsMapper newsMapper;

	@Inject
	private CategoryDAO categoryDAO;

	@Override
	public List<NewsModel> findAll() {
		String query = "SELECT * FROM news INNER JOIN category ON news.categoryid=category.id";
		return super.executeQuery(newsMapper, query);
	}

	@Override
	public NewsModel findOne(Long id) {
		String query = "SELECT * FROM news INNER JOIN category ON news.categoryId=category.id WHERE news.id = ?";
		List<NewsModel> newsModel = super.executeQuery(newsMapper, query, id);
		if(newsModel!=null&&newsModel.size()!=0) {
			return newsModel.get(0);
		}
		return null;
	}

	@Override
	public Long insert(NewsModel newsModel) {
		String query = "INSERT INTO news (title, content, thumbnail, shortdescription, categoryid, createddate, createdby, modifieddate, modifiedby) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String categoryCode = newsModel.getCategoryCode();
		CategoryModel categoryModel = categoryDAO.findByCategoryCode(categoryCode);
		Long categoryId = categoryModel!=null?categoryModel.getId():null;
		return super.insert(query, newsModel.getTitle(), newsModel.getContent(), newsModel.getThumbnail(), newsModel.getShortDescription(), categoryId, newsModel.getCreatedAt(), newsModel.getCreatedBy(), newsModel.getModifiedAt(), newsModel.getModifiedBy());
	}

	@Override
	public void update(NewsModel newsModel) {
		String query = "UPDATE news SET title = ?, content = ?, thumbnail = ?, shortdescription = ?, categoryid = ?, modifieddate = ?, modifiedby = ? WHERE id = ?";
		String categoryCode = newsModel.getCategoryCode();
		CategoryModel categoryModel = categoryDAO.findByCategoryCode(categoryCode);
		Long categoryId = categoryModel!=null?categoryModel.getId():null;
		super.executeUpdate(query, newsModel.getTitle(), newsModel.getContent(), newsModel.getThumbnail(), newsModel.getShortDescription(), categoryId, newsModel.getModifiedAt(), newsModel.getModifiedBy(), newsModel.getId());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM news WHERE id = ?";
		super.executeUpdate(query, id);
	}
	
}
