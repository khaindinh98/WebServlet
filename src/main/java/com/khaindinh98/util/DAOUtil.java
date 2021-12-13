package com.khaindinh98.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOUtil {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3307/myblog";
			String username = "root";
			String password = "";
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void setParameters(PreparedStatement pstmt, Object... parameters) throws SQLException {
		for(int i = 0; i < parameters.length; i++) {
			Object obj = parameters[i];
			if(obj instanceof Long) {
				pstmt.setLong(i+1, (Long)obj);
			} else if(obj instanceof String){
				pstmt.setString(i+1, (String)obj);
			}
		}
	}
}
