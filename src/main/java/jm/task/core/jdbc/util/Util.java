package jm.task.core.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String USER_NAME = "myuser";
    private static final String password = "mypassword";
    private static final String url = "jdbc:postgresql://localhost:5432/mydatabase";

    static public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, USER_NAME, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
