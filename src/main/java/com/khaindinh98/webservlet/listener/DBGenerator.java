package com.khaindinh98.webservlet.listener;

import com.khaindinh98.webservlet.util.DAOUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class DBGenerator implements ServletContextListener {

    private Logger logger = Logger.getLogger(DBGenerator.class.toString());

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Connection connection = DAOUtil.getConnection();
        Statement statement;
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'myblog'") ;
            if(resultSet.next()) {
                int countTable = resultSet.getInt(1);
                logger.info("Count Table: " + countTable);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
