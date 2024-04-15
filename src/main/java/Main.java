import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("1","1",(byte) 1);
//        userService.dropUsersTable();
        System.out.println(userService.getAllUsers());
    }
}
