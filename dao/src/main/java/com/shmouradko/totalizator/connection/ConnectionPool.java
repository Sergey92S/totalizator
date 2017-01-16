package com.shmouradko.totalizator.connection;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Revotech on 13.12.2016.
 */
public class ConnectionPool {
    private static Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private static final ConnectionPool INSTANCE = new ConnectionPool();

    private static final String CONNECTION_COUNT = "db.connection_count";
    private static final String DB_PROPERTIES_FILE = "resources.db";
    private static final int MINIMAL_CONNECTION_COUNT = 5;

    private BlockingQueue<ConnectionWrapper> availableConnections;
    private BlockingQueue<ConnectionWrapper> usedConnections;

    private ConnectionPool() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(DB_PROPERTIES_FILE);
        int connectionCount;
        try {
            connectionCount = Integer.parseInt(resourceBundle.getString(CONNECTION_COUNT));
        } catch (NumberFormatException e) {
            LOGGER.log(Level.ERROR, "Exception while reading connection number, minimal connection count was set");
            connectionCount = MINIMAL_CONNECTION_COUNT;
        }

        availableConnections = new ArrayBlockingQueue<>(connectionCount);
        usedConnections = new ArrayBlockingQueue<>(connectionCount);

        try {
            for (int i = 0; i < connectionCount; i++) {
                ConnectionWrapper connection = new ConnectionWrapper();
                availableConnections.put(connection);
            }
        } catch (SQLException | InterruptedException e){
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException(e);
        }
    }

    public static ConnectionPool getInstance() {
        return INSTANCE;
    }

    public ConnectionWrapper takeConnection() throws InterruptedException {
        ConnectionWrapper connection;
        connection = availableConnections.take();
        usedConnections.put(connection);
        return connection;
    }

    public void returnConnection(ConnectionWrapper connection) throws SQLException, InterruptedException {
        try {
            if (connection != null) {
                connection.setAutoCommit(true);
                usedConnections.remove(connection);
                availableConnections.put(connection);
            }
        } catch (InterruptedException | SQLException e) {
            throw new SQLException("Error during returning connection to the pool", e);
        }
    }

}
