package com.khaindinh98.webservlet.controller.admin;

import com.khaindinh98.webservlet.constant.SystemConstant;
import com.khaindinh98.webservlet.model.CategoryModel;
import com.khaindinh98.webservlet.model.NewsModel;
import com.khaindinh98.webservlet.model.ProductModel;
import com.khaindinh98.webservlet.model.UserModel;
import com.khaindinh98.webservlet.service.ICategoryService;
import com.khaindinh98.webservlet.service.INewsService;
import com.khaindinh98.webservlet.service.IProductService;
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

@WebServlet(urlPatterns = {"/admin-product"})
public class ProductController extends HttpServlet {

    private Logger logger = Logger.getLogger(ProductController.class.toString());

    @Inject
    private ICategoryService categoryService;

    @Inject
    private IProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        logger.info("------------------"+req.getContextPath());
//        logger.info("------------------"+req.getServletPath());
        ProductModel productModel = FormUtil.getInstance().toModel(req, ProductModel.class);
        String typeView = productModel.getType();
        if(typeView!=null) {
            if (typeView.equals(SystemConstant.LIST)) {
                List<ProductModel> listProducts = productService.findAll();
                req.setAttribute("listProducts", listProducts);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/product/list-view.jsp");
                requestDispatcher.forward(req, resp);
            } else if (typeView.equals(SystemConstant.EDIT)) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/product/edit-view.jsp");
                UserModel userModel = (UserModel) req.getSession().getAttribute("userModel");
                if(productModel.getId()!=null) {
                    productModel = productService.findOne(productModel.getId());
                }else{
                    productModel = new ProductModel();
                    productModel.setCreatedAt(LocalDateTime.now());
                    productModel.setCreatedBy(userModel.getUsername());
                    productModel.setModifiedAt(LocalDateTime.now());
                    productModel.setModifiedBy(userModel.getUsername());
                }
                req.setAttribute("productModel", productModel);
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
