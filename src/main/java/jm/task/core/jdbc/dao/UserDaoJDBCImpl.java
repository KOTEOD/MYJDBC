package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import javax.persistence.Id;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            var statement = connection.createStatement();
            String sql = """
                    CREATE TABLE IF NOT EXISTS USERS(
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(50),
                        lastName VARCHAR(50),
                        age INT
                                        );
                    """;
            statement.execute(sql);
            statement.close();
            System.out.println("CREATE TABLE");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            var statement = Util.getConnection().createStatement();
            String sql = """
                    DROP TABLE IF EXISTS USERS;
                    """;
            statement.executeUpdate(sql);
            statement.close();
            System.out.println("DROP TABLE");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            String sql = """
                    INSERT INTO USERS(name,lastName,age) VALUES (?,?,?)
                    """;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
            statement.close();
            System.out.println("INSERT INTO");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
        try {

            String sql = """
                    DELETE FROM USERS WHERE id = ?
                    """;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (int) id);
            statement.executeUpdate();
            statement.close();
            System.out.println("INSERT INTO");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<User> getAllUsers() {
        try {
            List<User> list = new ArrayList<>();
            var statement = Util.getConnection().createStatement();
            String sql = """
                    SELECT *
                    FROM users
                    """;
            var executeResult = statement.executeQuery(sql);
            statement.execute(sql);
            while (executeResult.next()) {
                User user = new User();
                user.setId(executeResult.getLong("id"));
                        user.setName(executeResult.getString("name"));
                        user.setLastName(executeResult.getString("lastName"));
                        user.setAge(executeResult.getByte("age"));
                list.add(user);
            }
            System.out.println(list);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void cleanUsersTable() {
        try {
            var statement = connection.createStatement();
            String sql = """
                    DELETE FROM USERS
                    """;
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("Удалено " + rowsAffected + " записей из таблицы USERS.");
            statement.close();
            System.out.println("INSERT INTO");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
