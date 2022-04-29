package com.khaindinh98.webservlet.util;

import java.sql.*;
import java.time.LocalDateTime;
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
            } else if (obj instanceof LocalDateTime) {
                pstmt.setTimestamp(i + 1, Timestamp.valueOf((LocalDateTime) obj));
            }else {
                pstmt.setNull(i + 1, java.sql.Types.NULL);
            }
        }
    }
}
