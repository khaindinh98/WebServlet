package com.khaindinh98.webservlet.dao;

import com.khaindinh98.webservlet.model.UserModel;

public interface IUserDAO extends IGenericDAO<UserModel>{

    public UserModel getUser(String username, String password);

    public UserModel findOne(Long id);

    public UserModel findAll();

    Long insert(UserModel userModel);

    void update(UserModel userModel);

    void delete(Long id);

}
