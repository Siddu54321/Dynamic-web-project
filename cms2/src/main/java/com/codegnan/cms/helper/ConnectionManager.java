package com.codegnan.cms.helper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class ConnectionManager {
    private static final Logger logger = Logger.getLogger(ConnectionManager.class);
    private static ConnectionManager instance;
    private String url;
    private String username;
    private String password;
    private String driver;

    private ConnectionManager() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("jdbc.properties")) {
            if (input == null) {
                logger.error("Sorry, unable to find jdbc.properties");
                return;
            }

            Properties prop = new Properties();
            prop.load(input);

            this.driver = prop.getProperty("jdbc.driver");
            this.url = prop.getProperty("jdbc.url");
            this.username = prop.getProperty("jdbc.username");
            this.password = prop.getProperty("jdbc.password");

            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            logger.error("Error loading database configuration", e);
        }
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            synchronized (ConnectionManager.class) {
                if (instance == null) {
                    instance = new ConnectionManager();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(url, username, password);
        con.setAutoCommit(false);
        logger.info("Database connection established");
        return con;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                logger.info("Database connection closed");
            } catch (SQLException e) {
                logger.error("Error closing database connection", e);
            }
        }
    }
}
