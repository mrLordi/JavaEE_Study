package main.java.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by win10 on 09.10.2016.
 */
public class ConnectionPool {

    private final String HOST;
    private final String USERNAME;
    private final String PASSWORD;
    private static ConnectionPool instance;

    private Set<Connection> availableConnections;
    private Set<Connection> usedConnections;

    private ConnectionPool(int connectionCount, InputStream inputStream) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error, class driver is missing!" + e.getMessage());
            System.exit(0);
        }

        Properties properties = new Properties();

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Config failed!" + e.getMessage());
        }

        HOST = properties.getProperty("host");
        USERNAME = properties.getProperty("username");
        PASSWORD = properties.getProperty("password");

        availableConnections = new HashSet<>();
        usedConnections = new HashSet<>();

        for (int i = 0; i < connectionCount; i++) {
            availableConnections.add(createConnection());
        }

    }

    public static synchronized ConnectionPool getInstance(int connectionCount, InputStream inputStream) {
        if (instance == null) {
            connectionCount = connectionCount <= 0 ? 1 : connectionCount;
            instance = new ConnectionPool(connectionCount, inputStream);
        }

        return instance;
    }

    public static synchronized ConnectionPool getInstance(InputStream inputStream) {
        if (instance == null) {
            instance = new ConnectionPool(1, inputStream);
        }

        return instance;
    }

    private Connection createConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connect failed!" + e.getMessage());
            System.exit(0);
        }

        return connection;
    }

    public synchronized ConnectionWrapper getConnection() {
        ConnectionWrapper connectionWrapper;
        Connection connection;

        if (availableConnections.size() == 0) {
            connection = createConnection();
            connectionWrapper = new ConnectionWrapper(connection, instance);
        } else {
            connection = availableConnections.iterator().next();
            connectionWrapper = new ConnectionWrapper(connection, instance);
            availableConnections.remove(connection);
        }
        usedConnections.add(connection);

        return connectionWrapper;
    }

    public synchronized void putBack(Connection connection) {
        if (connection != null && usedConnections.remove(connection)) {
            availableConnections.add(connection);
        }
    }

    public boolean closeAllConnections() {
        boolean result = true;
        Iterator iterator = availableConnections.iterator();
        while(iterator.hasNext()) {
            try (Connection connection = (Connection) iterator.next()) {
            } catch (SQLException e) {
                e.printStackTrace();
                result = false;
            }
        }

        return result;
    }
}
