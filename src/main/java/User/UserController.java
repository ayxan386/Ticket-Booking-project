package User;

import java.util.ArrayList;

public class UserController {
        private UserService userService;

        private UserController() {
                userService = new UserService();
        }

        boolean loginUser(User u) {
                throw new IllegalArgumentException("Not implemented yet");
        }

        boolean registerUser(User u) {
                throw new IllegalArgumentException("Not implemented yet");
        }

        ArrayList<String> getUserInfo(User u) {
                throw new IllegalArgumentException("Not implemented yet");
        }

        boolean deleteUser(User u) {
                throw new IllegalArgumentException("Not implemented yet");
        }

        public static UserController create() {
                return new UserController();
        }
}
