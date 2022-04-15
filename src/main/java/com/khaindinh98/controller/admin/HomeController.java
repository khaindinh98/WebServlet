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

@WebServlet(urlPatterns = {"/admin-homepage"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/dashboard.jsp");
        requestDispatcher.forward(req, resp);
    }
}
