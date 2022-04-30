package com.khaindinh98.webservlet.controller.admin.api;

import com.khaindinh98.webservlet.model.CategoryModel;
import com.khaindinh98.webservlet.model.NewsModel;
import com.khaindinh98.webservlet.model.UserModel;
import com.khaindinh98.webservlet.service.ICategoryService;
import com.khaindinh98.webservlet.service.impl.NewsService;
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

@WebServlet(urlPatterns = {"/api-admin-news/news"})
public class CategoryAPI extends HttpServlet{
	
	@Inject
	private ICategoryService categoryService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

        JSONUtil jsonUtil = JSONUtil.getInstance(req.getReader());
		CategoryModel categoryModel = jsonUtil.toModel(CategoryModel.class);
		categoryModel = categoryService.insert(categoryModel);
		jsonUtil.toOutputStream(resp.getOutputStream(), categoryModel);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPut(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JSONUtil jsonUtil = JSONUtil.getInstance(req.getReader());
		UserModel userModel = (UserModel) req.getSession().getAttribute("userModel");

		CategoryModel categoryModel = jsonUtil.toModel(CategoryModel.class);
		categoryModel.setModifiedAt(LocalDateTime.now());
		if(userModel!=null) {
			categoryModel.setModifiedBy(userModel.getUsername());
		}
		categoryService.update(categoryModel);
		jsonUtil.toOutputStream(resp.getOutputStream(), categoryModel);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doDelete(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
//		JSONUtil jsonUtil = JSONUtil.getInstance(req.getInputStream());
		CategoryModel categoryModel = FormUtil.getInstance().toModel(req, CategoryModel.class);
//		newsService.delete(jsonUtil.toModel(NewsModel.class).getIds());
		categoryService.delete(categoryModel.getId());
		resp.getOutputStream().print("{}");
	}
}
