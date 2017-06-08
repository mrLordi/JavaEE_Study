package connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by win10 on 03.10.2016.
 */
public class ConnectionManager {

    private final String HOST;
    private final String USERNAME;
    private final String PASSWORD;

    private final String propFileName = "config.properties";

    public ConnectionManager(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error, class driver is missing!" + e.getMessage());
            System.exit(0);
        }

        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Config failed!" + e.getMessage());
        }

        HOST = properties.getProperty("host");
        USERNAME = properties.getProperty("username");
        PASSWORD = properties.getProperty("password");

    }

    public Connection getConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connect failed!" + e.getMessage());
            System.exit(0);
        }

        return connection;

    }

}
