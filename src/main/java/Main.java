import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import jm.task.core.jdbc.service.UserServiceImpl;

;import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("ivan", "lol", (byte) 25);
        userService.saveUser("max", "kek", (byte) 23);
        userService.saveUser("andry", "mem", (byte) 20);
        userService.saveUser("leha", "dad", (byte) 15);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
