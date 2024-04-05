package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection = Util.getConnection();
    private static long flag = 0;
    String sqlCreateUsers = """
                    CREATE TABLE IF NOT EXISTS USERS(
                        id BIGINT PRIMARY KEY,
                        name VARCHAR(50),
                        lastName VARCHAR(50),
                        age INT
                                        );
                    """;

    String sqlDropUsers = """
                    DROP TABLE IF EXISTS USERS;
                    """;

    String sqlSaveUser = """
                    INSERT INTO USERS(id,name,lastName,age) VALUES (?,?,?,?)
                    """;

    String sqlRemoveUser = """
                    DELETE FROM USERS WHERE id = ?
                    """;

    String sqlGetAll = """
                    SELECT *
                    FROM users
                    """;

    String sqlCleanUsers = """
                    DELETE FROM USERS
                    """;

    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
        try (var statement = connection.createStatement()){
            statement.execute(sqlCreateUsers);
            System.out.println("CREATE TABLE");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        try (var statement = Util.getConnection().createStatement()){
            statement.executeUpdate(sqlDropUsers);
            System.out.println("DROP TABLE");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement statement = connection.prepareStatement(sqlSaveUser)){
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
        try (PreparedStatement statement = connection.prepareStatement(sqlRemoveUser)){
            statement.setInt(1, (int)id);
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
        try (var statement = Util.getConnection().createStatement()
             ;var executeResult = statement.executeQuery(sqlGetAll)){
            while (executeResult.next()) {
                User user = new User();
                user.setId(executeResult.getLong("id"));
                        user.setName(executeResult.getString("name"));
                        user.setLastName(executeResult.getString("lastName"));
                        user.setAge(executeResult.getByte("age"));
                list.add(user);
            }
            statement.execute(sqlGetAll);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        try (var statement = connection.createStatement()){;
            int rowsAffected = statement.executeUpdate(sqlCleanUsers);
            System.out.println("Удалено " + rowsAffected + " записей из таблицы USERS.");
            System.out.println("INSERT INTO");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
