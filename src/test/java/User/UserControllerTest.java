package User;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserControllerTest {
        private UserController userController;

        @Before
        public void setup() {
                userController = UserController.create();
        }

        @Test
        public void getAllUsers() {
                ArrayList<User> allUsers = userController.getAllUsers();
                ArrayList<User> expected = new ArrayList<User>();
                assertThat(allUsers, equalTo(expected));
        }
}