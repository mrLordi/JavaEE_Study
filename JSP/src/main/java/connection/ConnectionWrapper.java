package main.java.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by win10 on 09.10.2016.
 */
public class ConnectionWrapper implements AutoCloseable{

    Connection connection;
    ConnectionPool connectionPool;

    public ConnectionWrapper(Connection connection, ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.connection = connection;
    }

    @Override
    public void close() {
        connectionPool.putBack(connection);
    }

    public PreparedStatement prepareStatement(String query) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException e) {
            System.out.println("Error in ConnectionWrapper -> prepareStatement(query)" + e.getMessage());
        }

        return preparedStatement;
    }

    public Statement createStatement() {
        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Error in ConnectionWrapper -> createStatement() " + e.getMessage());
        }

        return statement;
    }
}
