package com.shmouradko.totalizator.connection;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by Revotech on 13.12.2016.
 */
public class ConnectionWrapper{
    private static Logger LOGGER = LogManager.getLogger(ConnectionWrapper.class);

    static {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            LOGGER.log(Level.FATAL, e + " DriverManager wasn't found");
            throw new RuntimeException(e);
        }
    }

    private static final String JDBC_URL = "db.jdbc_url";
    private static final String DB_LOGIN = "db.login";
    private static final String DB_PASSWORD = "db.password";
    private static final String DB_PROPERTIES_FILE = "resources.db";

    private Connection connection;

    ConnectionWrapper() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle(DB_PROPERTIES_FILE);
        String url = resource.getString(JDBC_URL);
        String login = resource.getString(DB_LOGIN);
        String password = resource.getString(DB_PASSWORD);
        connection = DriverManager.getConnection(url, login, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException {
        connection.setAutoCommit(autoCommit);
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }

}
