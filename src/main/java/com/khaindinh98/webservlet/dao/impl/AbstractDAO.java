package com.khaindinh98.webservlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.khaindinh98.webservlet.dao.IGenericDAO;
import com.khaindinh98.webservlet.mapper.AbstractRowMapper;
import com.khaindinh98.webservlet.model.AbstractModel;
import com.khaindinh98.webservlet.util.DAOUtil;

public abstract class AbstractDAO<T extends AbstractModel> implements IGenericDAO<T> {

	@Override
	public List<T> executeQuery(AbstractRowMapper<T> rowMapper, String query, Object... parameters) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtil.getConnection();
			preparedStatement = connection.prepareStatement(query);
			DAOUtil.setParameters(preparedStatement, parameters);
			resultSet = preparedStatement.executeQuery();
			List<T> result = new ArrayList<T>();
			while (resultSet.next()) {
				result.add(rowMapper.mapping(resultSet));
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public Long insert(String query, Object... parameters) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Long id = null;
		try {
			connection = DAOUtil.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			DAOUtil.setParameters(preparedStatement, parameters);
			int update = preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (update!=-1 && resultSet.next()) {
				id = resultSet.getLong(1);
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException ex) {
				e.printStackTrace();
//				throw new RuntimeException(ex);
			}
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}

	@Override
	public void executeUpdate(String query, Object... parameters) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtil.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			DAOUtil.setParameters(preparedStatement, parameters);
			preparedStatement.executeUpdate();
			int affectedRows = preparedStatement.getUpdateCount();
			if (affectedRows != 0) {
				connection.commit();
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
//				throw new RuntimeException(ex);
			}
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
