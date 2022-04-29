package com.khaindinh98.webservlet.mapper;

import com.khaindinh98.webservlet.model.NewsModel;
import com.khaindinh98.webservlet.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements IRowMapper<UserModel>{

	@Override
	public UserModel mapping(ResultSet resultSet) {
		try {
			UserModel userModel = new UserModel();
			userModel.setUsername(resultSet.getString("username"));
			userModel.setId(resultSet.getLong("id"));
			userModel.setRoleCode("ADMIN_ROLE");
			userModel.setRoleName("ADMIN_ROLE");
			return userModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
