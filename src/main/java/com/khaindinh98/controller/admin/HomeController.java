package com.khaindinh98.controller.admin;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.khaindinh98.constant.SystemConstant;
import com.khaindinh98.model.NewsModel;
import com.khaindinh98.util.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/admin-news"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        PrintWriter out = resp.getWriter();
//        out.println("Testing");
        NewsModel newsModel = FormUtil.getInstance().toModel(req, NewsModel.class);
        if(newsModel.getType()!=null) {
            if (newsModel.getType().equals(SystemConstant.LIST)) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/news/list-view.jsp");
                requestDispatcher.forward(req, resp);
            } else if (newsModel.getType().equals(SystemConstant.EDIT)) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/news/edit-view.jsp");
                requestDispatcher.forward(req, resp);
            }
        }else{
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/news/dashboard.jsp");
            requestDispatcher.forward(req, resp);
        }
        req.setAttribute("model", newsModel);

    }
}
