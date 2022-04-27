package com.khaindinh98.webservlet.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khaindinh98.webservlet.model.NewsModel;
import com.khaindinh98.webservlet.service.impl.NewsService;
import com.khaindinh98.webservlet.util.JSONUtil;

@WebServlet(urlPatterns = {"/api-admin-news/news"})
public class NewsAPI extends HttpServlet{
	
	@Inject
	private NewsService newsService;

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("application/json");
//		JSONUtil jsonUtil = JSONUtil.getInstance(req.getInputStream());
//		NewsModel newsModel = newsService.insert(jsonUtil.toModel(NewsModel.class));
//		jsonUtil.toOutputStream(resp.getOutputStream(), newsModel);
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
        JSONUtil jsonUtil = JSONUtil.getInstance(req.getInputStream());
		NewsModel newsModel = newsService.insert(jsonUtil.toModel(NewsModel.class));
		jsonUtil.toOutputStream(resp.getOutputStream(), newsModel);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPut(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JSONUtil jsonUtil = JSONUtil.getInstance(req.getInputStream());
		NewsModel newNewsModel = newsService.update(jsonUtil.toModel(NewsModel.class));
		jsonUtil.toOutputStream(resp.getOutputStream(), newNewsModel);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doDelete(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JSONUtil jsonUtil = JSONUtil.getInstance(req.getInputStream());
		newsService.delete(jsonUtil.toModel(NewsModel.class).getIds());
		resp.getOutputStream().print("{}");
	}
}
