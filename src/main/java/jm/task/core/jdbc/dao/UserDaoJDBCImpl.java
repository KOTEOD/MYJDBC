package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    final Connection connection = Util.getConnection();
    static long flag = 0;

    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
        try (var statement = connection.createStatement()){
            String sql = """
                    CREATE TABLE IF NOT EXISTS USERS(
                        id BIGINT PRIMARY KEY,
                        name VARCHAR(50),
                        lastName VARCHAR(50),
                        age INT
                                        );
                    """;
            statement.execute(sql);
            System.out.println("CREATE TABLE");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        try (var statement = Util.getConnection().createStatement()){
            String sql = """
                    DROP TABLE IF EXISTS USERS;
                    """;
            statement.executeUpdate(sql);
            System.out.println("DROP TABLE");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            String sql = """
                    INSERT INTO USERS(id,name,lastName,age) VALUES (?,?,?,?)
                    """;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, flag++);
            statement.setString(2, name);
            statement.setString(3, lastName);
            statement.setByte(4, age);
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
        List<User> list = new ArrayList<>();
        try (var statement = Util.getConnection().createStatement()){
            String sql = """
                    SELECT *
                    FROM users
                    """;
            var executeResult = statement.executeQuery(sql);
            while (executeResult.next()) {
                User user = new User();
                user.setId(executeResult.getLong("id"));
                        user.setName(executeResult.getString("name"));
                        user.setLastName(executeResult.getString("lastName"));
                        user.setAge(executeResult.getByte("age"));
                list.add(user);
            }
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        try (var statement = connection.createStatement()){;
            String sql = """
                    DELETE FROM USERS
                    """;
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("Удалено " + rowsAffected + " записей из таблицы USERS.");
            System.out.println("INSERT INTO");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
