package com.khaindinh98.webservlet.controller.admin;

import com.khaindinh98.webservlet.constant.SystemConstant;
import com.khaindinh98.webservlet.model.CategoryModel;
import com.khaindinh98.webservlet.model.NewsModel;
import com.khaindinh98.webservlet.model.UserModel;
import com.khaindinh98.webservlet.service.ICategoryService;
import com.khaindinh98.webservlet.service.INewsService;
import com.khaindinh98.webservlet.util.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/admin-news"})
public class NewsController extends HttpServlet {

    private Logger logger = Logger.getLogger(NewsController.class.toString());

    @Inject
    private ICategoryService categoryService;

    @Inject
    private INewsService newsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        logger.info("------------------"+req.getContextPath());
//        logger.info("------------------"+req.getServletPath());
        NewsModel newsModel = FormUtil.getInstance().toModel(req, NewsModel.class);
        String typeView = newsModel.getType();
        if(typeView!=null) {
            if (typeView.equals(SystemConstant.LIST)) {
                List<NewsModel> listNews = newsService.findAll();
                req.setAttribute("listNews", listNews);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/news/list-view.jsp");
                requestDispatcher.forward(req, resp);
            } else if (typeView.equals(SystemConstant.EDIT)) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/news/edit-view.jsp");
                UserModel userModel = (UserModel) req.getSession().getAttribute("userModel");
                if(newsModel.getId()!=null) {
                    newsModel = newsService.findOne(newsModel.getId());
                }else{
                    newsModel = new NewsModel();
                    newsModel.setCreatedAt(LocalDateTime.now());
                    newsModel.setCreatedBy(userModel.getUsername());
                    newsModel.setModifiedAt(LocalDateTime.now());
                    newsModel.setModifiedBy(userModel.getUsername());
                }
                req.setAttribute("newsModel", newsModel);
                List<CategoryModel> listCategories = categoryService.findAll();
                req.setAttribute("listCategories", listCategories);
                requestDispatcher.forward(req, resp);

            }else{
//                resp.sendRedirect(req.getContextPath() + "/admin-homepage");
            }
        }else{
//            resp.sendRedirect(req.getContextPath() + "/admin-homepage");
        }
    }

}
