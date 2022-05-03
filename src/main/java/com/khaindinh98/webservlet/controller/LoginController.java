package com.khaindinh98.webservlet.controller;

import com.khaindinh98.webservlet.model.RoleModel;
import com.khaindinh98.webservlet.model.UserModel;
import com.khaindinh98.webservlet.service.IUserService;
import com.khaindinh98.webservlet.util.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Inject
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("userModel")==null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
            requestDispatcher.forward(req, resp);
        }else{
            authorizeRequest(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel = FormUtil.getInstance().toModel(req, UserModel.class);
        if(userService.authenticate(req, userModel)){
            authorizeRequest(req, resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/login");
        }
    }
    private void authorizeRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String role = userService.authorize(req);
        if(role.equals(RoleModel.ADMIN_ROLE)){
            resp.sendRedirect(req.getContextPath()+"/admin-homepage");
        }else{
            resp.sendRedirect(req.getContextPath());
        }
    }
}
