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
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/admin-category"})
public class CategoryController extends HttpServlet {

    private Logger logger = Logger.getLogger(CategoryController.class.toString());

    @Inject
    private ICategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        logger.info("------------------"+req.getContextPath());
//        logger.info("------------------"+req.getServletPath());
        CategoryModel categoryModel = FormUtil.getInstance().toModel(req, CategoryModel.class);
        String typeView = categoryModel.getType();
        if(categoryModel.getType()!=null) {
            if (typeView.equals(SystemConstant.LIST)) {
                List<CategoryModel> listCategories = categoryService.findAll();
                req.setAttribute("listCategories", listCategories);
                req.setAttribute("typeView", typeView);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/category/list-view.jsp");
                requestDispatcher.forward(req, resp);
            } else if (typeView.equals(SystemConstant.EDIT)) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/category/edit-view.jsp");
                UserModel userModel = (UserModel) req.getSession().getAttribute("userModel");
                if(categoryModel.getId()!=null) {
                    categoryModel = categoryService.findOne(categoryModel.getId());
                }else{
                    categoryModel = new CategoryModel();
                    categoryModel.setCreatedAt(LocalDateTime.now());
                    categoryModel.setCreatedBy(userModel.getUsername());
                    categoryModel.setModifiedAt(LocalDateTime.now());
                    categoryModel.setModifiedBy(userModel.getUsername());
                }
                req.setAttribute("categoryModel", categoryModel);
                requestDispatcher.forward(req, resp);

            }else{
                resp.sendRedirect(req.getContextPath() + "/admin-homepage");
            }
        }else{
            resp.sendRedirect(req.getContextPath() + "/admin-homepage");
        }
    }

}
