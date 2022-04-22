package com.khaindinh98.webservlet.service.impl;

import com.khaindinh98.webservlet.dao.impl.UserDAO;
import com.khaindinh98.webservlet.model.UserModel;
import com.khaindinh98.webservlet.service.IUserService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserService implements IUserService {

    @Inject
    private UserDAO userDAO;

    @Override
    public boolean authenticate(HttpServletRequest req, UserModel userModel1) {

        String username = userModel1.getUsername();
        String password = userModel1.getPassword();

        UserModel userModel2 = userDAO.getUser(username, password);
        if(userModel2 != null){
            req.getSession().setAttribute("userModel", userModel2);
            return true;
        }
        return false;
    }

    @Override
    public String authorize(HttpServletRequest req) {
        UserModel userModel = (UserModel) req.getSession().getAttribute("userModel");
        if(userModel != null){
            return userModel.getRoleCode();
        }
        return null;
    }
}
