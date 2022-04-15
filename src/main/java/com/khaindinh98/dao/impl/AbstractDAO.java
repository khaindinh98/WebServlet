package com.khaindinh98.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.khaindinh98.dao.IGenericDAO;
import com.khaindinh98.mapper.IRowMapper;
import com.khaindinh98.util.DAOUtil;

public abstract class AbstractDAO<T> implements IGenericDAO<T> {

	@Override
	public List<T> executeQuery(IRowMapper<T> rowMapper, String query, Object... parameters) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DAOUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			DAOUtil.setParameters(pstmt, parameters);
			rs = pstmt.executeQuery();
			List<T> result = new ArrayList<T>();
			while (rs.next()) {
				result.add(rowMapper.mapping(rs));
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public Long insert(String query, Object... parameters) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DAOUtil.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			DAOUtil.setParameters(pstmt, parameters);
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				conn.commit();
				return rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void executeUpdate(String query, Object... parameters) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DAOUtil.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			DAOUtil.setParameters(pstmt, parameters);
			pstmt.executeUpdate();
			int affectedRows = pstmt.getUpdateCount();
			if (affectedRows != 0) {
				conn.commit();
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
