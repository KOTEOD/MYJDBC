import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;
;
        public class Main {
            public static void main(String[] args) {
                UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
                userDaoJDBC.createUsersTable();
                userDaoJDBC.dropUsersTable();
                userDaoJDBC.cleanUsersTable();
                userDaoJDBC.saveUser("ivan", "lol", (byte) 25);
                userDaoJDBC.saveUser("max", "kek", (byte) 23);
                userDaoJDBC.removeUserById(1);
                userDaoJDBC.getAllUsers();
        // реализуйте алгоритм здесь

    }
}
