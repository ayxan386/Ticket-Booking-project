package User;

import java.util.ArrayList;
import java.util.Optional;

public class UserController {
  private UserService userService;
  private Optional<User> loggedUser;

  private UserController() {
    userService = new UserService();
  }

  public static UserController create() {
    return new UserController();
  }

  public boolean loginUser(User u, String pass) {
    if (!userService.match(u.getId(), Encrypter.encrypt(pass)))
      throw new IllegalArgumentException("Wrong password");
    loggedUser = Optional.of(userService.get(u.getId()));
    return true;
  }

  public boolean registerUser(User u) {
    loggedUser = Optional.of(u);
    return userService.smartAdd(u);
  }

  public boolean registerUser(User u, String pass) {
    pass = Encrypter.encrypt(pass);
    loggedUser = Optional.of(u);
    return userService.smartAdd(new User(u, pass));
  }

  public ArrayList<String> getUserInfo(User u) {
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

  public void eraseAllData() {
    userService.eraseData();
  }

  public Optional<User> getLoggedUser() {
    return loggedUser;
  }

  public void update(User user) {
    userService.update(user);
  }
}
