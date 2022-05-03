package com.khaindinh98.webservlet.service;

import com.khaindinh98.webservlet.model.ProductModel;

import java.util.List;

public interface IProductService {

	List<ProductModel> findAll();

	ProductModel findOne(Long id);

	ProductModel insert(ProductModel productModel);

	void update(ProductModel productModel);

	void delete(Long id);

	void delete(Long[] ids);
}
