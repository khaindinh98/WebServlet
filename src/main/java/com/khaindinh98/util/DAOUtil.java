package com.khaindinh98.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DAOUtil {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("database");

    public static Connection getConnection() {
        try {
            Class.forName(resourceBundle.getString("driverName"));
            String url = resourceBundle.getString("urlDB");
            String username = resourceBundle.getString("username");
            String password = resourceBundle.getString("password");
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
        for (int i = 0; i < parameters.length; i++) {
            Object obj = parameters[i];
            if (obj instanceof Long) {
                pstmt.setLong(i + 1, (Long) obj);
            } else if (obj instanceof String) {
                pstmt.setString(i + 1, (String) obj);
            }
        }
    }
}
