import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;
;
        public class Main {
            public static void main(String[] args) {
                UserServiceImpl userService = new UserServiceImpl();
                userService.createUsersTable();
                userService.saveUser("ivan", "lol", (byte) 25);
                userService.saveUser("max", "kek", (byte) 23);
                userService.saveUser("andry", "mem", (byte) 20);
                userService.saveUser("leha", "dad", (byte) 15);
                userService.getAllUsers();
                userService.cleanUsersTable();
                userService.dropUsersTable();
        // реализуйте алгоритм здесь

    }
}
