package User;

import java.util.ArrayList;

public class UserController {
        private UserService userService;

        public ArrayList<User> getAllUsers() {
                return userService.getAllUsers();
        }
}
