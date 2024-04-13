import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;
;
        public class Main {
            public static void main(String[] args) {
                UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
//        userDaoJDBC.createUsersTable();
//        userDaoJDBC.dropUsersTable();
//        userDaoJDBC.cleanUsersTable();
//        userDaoJDBC.saveUser("ivan","lol", (byte) 25);
//        userDaoJDBC.saveUser("max","kek", (byte) 23);
//        userDaoJDBC.removeUserById(1);
//        userDaoJDBC.getAllUsers();
        // реализуйте алгоритм здесь
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        User user = new User("1", "1", (byte) 1);
        try (Session session = sessionFactory.getCurrentSession();) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }
}
