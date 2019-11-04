package User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserControllerTest {
        private UserController userController = UserController.create();
        private User u1;
        private User u2;

        @Before
        public void setup() {
                System.out.println(userController.getAllUsers());
                u1 = new User("Tester", "Testing", "test", "1000000");
                u2 = new User("Tester2", "Testing2", "test2", "1000001");
        }

        @After
        public void after() {
                userController.eraseAllData();
        }
        @Test
        public void registerNewUser() {
                boolean res = userController.registerUser(u1);
                boolean expected = true;
                assertThat(res, equalTo(expected));
        }

        @Test
        public void registerAlreadyExistingUser() {
                userController.registerUser(u1);
                boolean res = userController.registerUser(u1);
                boolean expected = false;
                assertThat(res, equalTo(expected));
        }

        @Test
        public void loginNonExistingUser() {
                boolean res = userController.loginUser(u2);
                boolean expected = false;
                assertThat(res, equalTo(expected));
        }

        @Test
        public void loginExistingUser() {
                boolean res = userController.loginUser(u1);
                boolean expected = true;
                assertThat(res, equalTo(expected));
        }

        @Test
        public void getUserInfo() {
                userController.registerUser(u1);
                ArrayList<String> bookings = userController.getUserInfo(u1);
                ArrayList<String> expectedBookings = new ArrayList<String>() {{
                        add(u1.getName());
                        add(u1.getSurname());
                        add(u1.getNickname());
                        add(u1.getId());
                }};
                assertThat(bookings, equalTo(expectedBookings));
        }

        @Test
        public void deleteUser() {
                userController.registerUser(u1);
                boolean res = userController.deleteUser(u1);
                boolean expected = true;
                assertThat(res, equalTo(expected));
        }

        @Test
        public void deleteNonUser() {
                boolean res = userController.deleteUser(u2);
                boolean expected = false;
                assertThat(res, equalTo(expected));
        }
}