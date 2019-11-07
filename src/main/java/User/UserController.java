package User;

import java.util.ArrayList;

public class UserController {
        private UserService userService;

        private UserController() {
                userService = new UserService();
        }

        boolean loginUser(User u, String pass) {
                return userService.match(u.getId(), Encrypter.encrypt(pass));
        }

        boolean registerUser(User u) {
                return userService.smartAdd(u);
        }

        boolean registerUser(User u, String pass) {
                pass = Encrypter.encrypt(pass);
                return userService.smartAdd(new User(u, pass));
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

        public void eraseAllData() {
                userService.eraseData();
        }
}
