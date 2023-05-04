package co.edu.sena.project2687351.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static String URL = "jdbc:mysql://localhost:3306/myapp?serverTimezone=America/Bogota";
    private static String USER = "1";
    private static String PASS = "1234";
    private static BasicDataSource pool;
    public static BasicDataSource
    getInstance() throws SQLException {
        if (pool == null) {
            pool = new BasicDataSource();
            pool.setUrl(URL);
            pool.setUsername(USER);
            pool.setPassword(PASS);
            pool.setInitialSize(5);
            pool.setMinIdle(5);
            pool.setMaxIdle(10);
            pool.setMaxTotal(10);
        }
        return pool;
    }
    public static Connection getConnection()
            throws SQLException {
        return getInstance().getConnection();
    }
} // ConnectionPool