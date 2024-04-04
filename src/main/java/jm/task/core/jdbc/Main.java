package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.dropUsersTable();
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.saveUser("ivan","lol", (byte) 25);
        userDaoJDBC.removeUserById(1);
        userDaoJDBC.getAllUsers();
        // реализуйте алгоритм здесь
    }
}
