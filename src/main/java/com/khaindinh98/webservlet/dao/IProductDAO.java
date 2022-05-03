package com.khaindinh98.webservlet.dao;

import com.khaindinh98.webservlet.model.NewsModel;
import com.khaindinh98.webservlet.model.ProductModel;

import java.util.List;

public interface IProductDAO extends IGenericDAO<ProductModel>{
	
	List<ProductModel> findAll();

	ProductModel findOne(Long id);
	
	Long insert(ProductModel productModel);
	
	void update(ProductModel productModel);
	
	void delete(Long id);
	
}
