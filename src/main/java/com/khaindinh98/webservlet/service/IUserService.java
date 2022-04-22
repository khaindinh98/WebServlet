package com.khaindinh98.webservlet.service;

import com.khaindinh98.webservlet.model.UserModel;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {
    public boolean authenticate(HttpServletRequest req, UserModel userModel);
    public String authorize(HttpServletRequest req);
}
