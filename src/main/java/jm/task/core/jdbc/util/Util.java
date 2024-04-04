package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String USER_NAME = "roots";
    public static final String password = "roots";
    public static final String url = "jdbc:mysql://localhost:3306/mydbtest";

    public static void main(String[] args) {
        Class<Driver> driver = Driver.class;
        try (Connection connection = DriverManager.getConnection(url, USER_NAME, password)) {
            System.out.println("Connect ok to DB Transaction: " + connection.getTransactionIsolation());
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n" + "Connect no to BD");
        }
    }
    static public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, USER_NAME, password);
            System.out.println("getConnection OK");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
