package com.khaindinh98.webservlet.service.impl;

import com.khaindinh98.webservlet.dao.impl.ProductDAO;
import com.khaindinh98.webservlet.model.ProductModel;
import com.khaindinh98.webservlet.service.IProductService;

import javax.inject.Inject;
import java.util.List;

public class ProductService implements IProductService {

	@Inject
	private ProductDAO productDAO;

	@Override
	public List<ProductModel> findAll() {
		return productDAO.findAll();
	}

	@Override
	public ProductModel findOne(Long id) {
		return productDAO.findOne(id);
	}

	@Override
	public ProductModel insert(ProductModel productModel) {
		Long id = productDAO.insert(productModel);
		return productDAO.findOne(id);
	}

	@Override
	public void update(ProductModel productModel) {
		productDAO.update(productModel);
	}

	@Override
	public void delete(Long id) {
		productDAO.delete(id);
	}

	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			productDAO.delete(id);
		}
	}
}
