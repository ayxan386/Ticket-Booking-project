package User;

import java.util.ArrayList;
import java.util.Set;

public class UserController {
        private UserService userService;

        private UserController() {
                userService = new UserService();
        }

        boolean loginUser(User u) {
                throw new IllegalArgumentException("Not implemented yet");
        }

        boolean registerUser(User u) {
                return userService.smartAdd(u);
        }

        ArrayList<String> getUserInfo(User u) {
                User temp = userService.get(u.getId());
                return new ArrayList<String>() {{
                        add(temp.getName());
                        add(temp.getSurname());
                        add(temp.getNickname());
                        add(temp.getId());
                }};
        }

        boolean deleteUser(User u) {
                return userService.smartRemove(u);
        }

        public static UserController create() {
                return new UserController();
        }

        public Set<User> getAllUsers() {
                return userService.getAllUsers();
        }
}
