import consoleControl.UserCommands.UserAccountCommands;
import consoleControl.UserInterface;

public class App {
  public static void main(String[] args) {
    UserInterface t = new UserInterface();
    UserAccountCommands.greetUser(t.userController, t.flightController, t.scanner);
    t.chooseCommand();
  }
}
