package User;

import java.util.ArrayList;

public class UserController {
        private UserService userService;

        private UserController() {
                userService = new UserService();
        }
        public ArrayList<User> getAllUsers() {
                return userService.getAllUsers();
        }

        public static UserController create() {
                return new UserController();
        }
}
