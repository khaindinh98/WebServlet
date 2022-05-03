package com.khaindinh98.webservlet.controller.admin.api;

import com.khaindinh98.webservlet.model.ProductModel;
import com.khaindinh98.webservlet.model.UserModel;
import com.khaindinh98.webservlet.service.IProductService;
import com.khaindinh98.webservlet.util.FormUtil;
import com.khaindinh98.webservlet.util.JSONUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = {"/api-admin-product/products"})
public class ProductAPI extends HttpServlet{
	
	@Inject
	private IProductService productService;

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("application/json");
//		JSONUtil jsonUtil = JSONUtil.getInstance(req.getInputStream());
//		productModel productModel = productService.insert(jsonUtil.toModel(productModel.class));
//		jsonUtil.toOutputStream(resp.getOutputStream(), productModel);
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

        JSONUtil jsonUtil = JSONUtil.getInstance(req.getReader());
		ProductModel productModel = jsonUtil.toModel(ProductModel.class);
		productModel = productService.insert(productModel);
		jsonUtil.toOutputStream(resp.getOutputStream(), productModel);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPut(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JSONUtil jsonUtil = JSONUtil.getInstance(req.getReader());
		UserModel userModel = (UserModel) req.getSession().getAttribute("userModel");

		ProductModel productModel = jsonUtil.toModel(ProductModel.class);
		productModel.setModifiedAt(LocalDateTime.now());
		if(userModel!=null) {
			productModel.setModifiedBy(userModel.getUsername());
		}
		productService.update(productModel);
		jsonUtil.toOutputStream(resp.getOutputStream(), productModel);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doDelete(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
//		JSONUtil jsonUtil = JSONUtil.getInstance(req.getInputStream());
		ProductModel productModel = FormUtil.getInstance().toModel(req, ProductModel.class);
//		productService.delete(jsonUtil.toModel(productModel.class).getIds());
		productService.delete(productModel.getId());
		resp.getOutputStream().print("{}");
	}
}
