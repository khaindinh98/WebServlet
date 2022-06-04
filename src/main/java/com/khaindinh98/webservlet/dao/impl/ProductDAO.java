package com.khaindinh98.webservlet.dao.impl;

import com.khaindinh98.webservlet.dao.ICategoryDAO;
import com.khaindinh98.webservlet.dao.IProductDAO;
import com.khaindinh98.webservlet.mapper.ProductMapper;
import com.khaindinh98.webservlet.model.CategoryModel;
import com.khaindinh98.webservlet.model.NewsModel;
import com.khaindinh98.webservlet.model.ProductModel;

import javax.inject.Inject;
import java.util.List;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {

	private ProductMapper productMapper = new ProductMapper();

	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<ProductModel> findAll() {
		String query = "SELECT * FROM product INNER JOIN category ON product.category_id=category.id";
		return super.executeQuery(productMapper, query);
	}

	@Override
	public ProductModel findOne(Long id) {
		String query = "SELECT * FROM product INNER JOIN category ON product.category_id=category.id WHERE product.id = ?";
		List<ProductModel> listProducts= super.executeQuery(productMapper, query, id);
		if(listProducts!=null&&listProducts.size()!=0) {
			return listProducts.get(0);
		}
		return null;
	}

	@Override
	public Long insert(ProductModel productModel) {
		String query = "INSERT INTO `myblog`.`product` (`name_product`, `thumbnail`, `short_description`, `description`, `price`, `discount_price`, `quantity`, `category_id`, `created_at`, `modified_at`, `created_by`, `modified_by`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		String categoryCode = productModel.getCategoryCode();
		CategoryModel categoryModel = categoryDAO.findByCategoryCode(categoryCode);
		Long categoryId = categoryModel!=null?categoryModel.getId():null;
		return super.insert(query,
				productModel.getNameProduct(),
				productModel.getThumbnail(),
				productModel.getShortDescription(),
				productModel.getDescription(),
				productModel.getPrice(),
				productModel.getDiscountPrice(),
				productModel.getQuantity(),
				categoryId,
				productModel.getCreatedAt(),
				productModel.getModifiedAt(),
				productModel.getCreatedBy(),
				productModel.getModifiedBy());
	}

	@Override
	public void update(ProductModel productModel) {
		String query = "UPDATE product SET name_product = ?, thumbnail = ?, short_description = ?, description = ?, price = ?, discount_price = ?, quantity = ?, category_id = ?, modified_at = ?, modified_by = ? WHERE ( id = ? )";
		String categoryCode = productModel.getCategoryCode();
		CategoryModel categoryModel = categoryDAO.findByCategoryCode(categoryCode);
		Long categoryId = categoryModel!=null?categoryModel.getId():null;
		super.executeUpdate(query,
				productModel.getNameProduct(),
				productModel.getThumbnail(),
				productModel.getShortDescription(),
				productModel.getDescription(),
				productModel.getPrice(),
				productModel.getDiscountPrice(),
				productModel.getQuantity(),
				categoryId,
				productModel.getModifiedAt(),
				productModel.getModifiedBy(),
				productModel.getId()
		);
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM product WHERE id = ?";
		super.executeUpdate(query, id);
	}
	
}
