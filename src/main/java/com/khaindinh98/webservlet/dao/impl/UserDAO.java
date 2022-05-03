package com.khaindinh98.webservlet.dao.impl;

import com.khaindinh98.webservlet.dao.IUserDAO;
import com.khaindinh98.webservlet.mapper.UserMapper;
import com.khaindinh98.webservlet.model.UserModel;

import javax.inject.Inject;
import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

    private UserMapper userMapper = new UserMapper();

    @Override
    public UserModel getUser(String username, String password) {
        String sql = "SELECT * FROM user INNER JOIN role ON user.role_id = role.id WHERE user.username = ? AND user.password = ?";
        List<UserModel> userModelList = executeQuery(userMapper, sql, username, password);
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
