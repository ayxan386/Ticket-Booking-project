package ConsoleControl.UserCommands;

import ConsoleControl.FlightCommands.FlightCommands;
import Flight.FlightController;
import User.User;
import User.UserController;

import java.util.Scanner;

public class UserAccountCommands {
  public static void loginUser(UserController userController, Scanner scanner) {
    System.out.println("Please enter the following information: ");
    String nickname, password;

    System.out.print("Nickname: ");
    nickname = scanner.nextLine();
    System.out.print("Password: ");
    password = scanner.nextLine();

    User u = new User("", "", nickname);
    try {
      userController.loginUser(u, password);
    } catch (Exception e) {
      System.out.println("Wrong nickname or password please try again");
      loginUser(userController, scanner);
    }
  }

  public static void registerUser(UserController userController, Scanner scanner) {
    System.out.println("Please enter the following information: ");
    String name, surname, nickname, pass;

    System.out.print("Enter name: ");
    name = scanner.nextLine();
    System.out.print("Enter surname: ");
    surname = scanner.nextLine();
    System.out.print("Choose a nickname: ");
    nickname = scanner.nextLine();
    System.out.print("Choose a strong password: ");
    pass = scanner.nextLine();

    User user = new User(name, surname, nickname);
    userController.registerUser(user, pass);
  }

  public static void greetUser(UserController userController, FlightController flightController, Scanner scanner) {
    if (flightController.getAllFlights().size() < 3) {
      FlightCommands.generateDatabase(flightController, scanner);
    }

    System.out.println("Hello and welcome to our Flight booking app");
    System.out.println("Do you have an account?");
    String answer = scanner.nextLine();
    switch (answer.toLowerCase()) {
      case "yes":
        loginUser(userController, scanner);
        break;
      case "no":
        registerUser(userController, scanner);
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + answer.toLowerCase());
    }
  }
}
