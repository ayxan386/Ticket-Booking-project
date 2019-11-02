package User;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserControllerTest {
        private UserController userController;
        private User u1;
        private User u2;
        @Before
        public void setup() {
                userController = UserController.create();
                u1 = new User("Tester", "Testing", "test", "1000000");
                u1 = new User("Tester2", "Testing2", "test2", "1000001");
        }

        @Test
        public void registerNewUser() {
                boolean res = userController.registerUser(u1);
                boolean expected = true;
                assertThat(res, equalTo(expected));
        }

        @Test
        public void registerAlreadyExistingUser() {
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
                ArrayList<String> bookings = userController.getUserInfo(u1);
                ArrayList<String> expectedBookings = new ArrayList<String>();
                assertThat(bookings, equalTo(expectedBookings));
        }

        @Test
        public void deleteUser() {
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