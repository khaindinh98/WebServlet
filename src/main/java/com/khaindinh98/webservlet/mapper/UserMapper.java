package com.khaindinh98.webservlet.mapper;

import com.khaindinh98.webservlet.model.UserModel;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper extends AbstractRowMapper<UserModel> {

	@Override
	public UserModel mapping(ResultSet resultSet) {
		try {
			UserModel userModel = new UserModel();
			userModel = mappingDefaultFields(resultSet, userModel);
			userModel.setUsername(resultSet.getString("username"));
			userModel.setRoleName(resultSet.getString("name_role"));
			userModel.setRoleCode(resultSet.getString("code_role"));
			return userModel;
		} catch (SQLException e) {
			return null;
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

}
