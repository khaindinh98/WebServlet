package com.khaindinh98.webservlet.dao.impl;

import com.khaindinh98.webservlet.dao.IUserDAO;
import com.khaindinh98.webservlet.mapper.IRowMapper;
import com.khaindinh98.webservlet.mapper.UserMapper;
import com.khaindinh98.webservlet.model.UserModel;

import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {


    @Override
    public UserModel getUser(String username, String password) {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        List<UserModel> userModelList = executeQuery(new UserMapper(), sql, username, password);
        if(userModelList!=null && !userModelList.isEmpty()){
            return userModelList.get(0);
        }
        return null;
    }

    @Override
    public UserModel findOne(Long id) {
        return null;
    }

    @Override
    public UserModel findAll() {
        return null;
    }

    @Override
    public Long insert(UserModel userModel) {
        return null;
    }

    @Override
    public void update(UserModel userModel) {

    }

    @Override
    public void delete(Long id) {

    }
}
