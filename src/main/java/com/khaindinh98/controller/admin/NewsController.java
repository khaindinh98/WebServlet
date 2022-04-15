package com.khaindinh98.controller.admin;

import com.khaindinh98.constant.SystemConstant;
import com.khaindinh98.model.CategoryModel;
import com.khaindinh98.model.NewsModel;
import com.khaindinh98.service.ICategoryService;
import com.khaindinh98.util.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-news"})
public class NewsController extends HttpServlet {

    @Inject
    private ICategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsModel newsModel = FormUtil.getInstance().toModel(req, NewsModel.class);
        List<CategoryModel> listCategories = categoryService.findAll();
        req.setAttribute("newsModel", newsModel);
        req.setAttribute("listCategories", listCategories);
        if(newsModel.getType()!=null) {
            if (newsModel.getType().equals(SystemConstant.LIST)) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/news/list-view.jsp");
                requestDispatcher.forward(req, resp);
            } else if (newsModel.getType().equals(SystemConstant.EDIT)) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/news/edit-view.jsp");
                requestDispatcher.forward(req, resp);
            }else{
                resp.sendRedirect(req.getContextPath() + "/admin-homepage");
            }
        }else{
            resp.sendRedirect(req.getContextPath() + "/admin-homepage");
        }
    }
}
