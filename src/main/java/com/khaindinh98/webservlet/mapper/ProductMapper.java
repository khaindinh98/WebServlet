package com.khaindinh98.webservlet.mapper;

import com.khaindinh98.webservlet.model.ProductModel;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper extends AbstractRowMapper<ProductModel> {

	@Override
	public ProductModel mapping(ResultSet resultSet) {
		try {
			ProductModel productModel = new ProductModel();
			productModel = mappingDefaultFields(resultSet, productModel);
			productModel.setNameProduct(resultSet.getString("name_product"));
			productModel.setThumbnail(resultSet.getString("thumbnail"));
			productModel.setShortDescription(resultSet.getString("short_description"));
			productModel.setDescription(resultSet.getString("description"));
			if(resultSet.getBigDecimal("price")!=null){
				productModel.setPrice(resultSet.getBigDecimal("price").toBigInteger());
			}
			if(resultSet.getBigDecimal("discount_price")!=null) {
				productModel.setDiscountPrice(resultSet.getBigDecimal("discount_price").toBigInteger());
			}
			productModel.setQuantity(resultSet.getLong("quantity"));
			productModel.setCategoryName(resultSet.getString("name_category"));
			productModel.setCategoryCode(resultSet.getString("code_category"));
			return productModel;
		} catch (SQLException e) {
			return null;
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

}
