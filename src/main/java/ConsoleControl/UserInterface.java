package ConsoleControl;

import Booking.BookingController;
import ConsoleControl.FlightCommands.FlightCommands;
import ConsoleControl.UserCommands.UserBookingCommands;
import Flight.FlightController;
import User.User;
import User.UserController;

import java.util.Scanner;

public class UserInterface {
  private Scanner scanner = new Scanner(System.in);

  private UserController userController;
  private FlightController flightController;
  private BookingController bookingController;

  public UserInterface() {
    userController = UserController.create();
    flightController = FlightController.create();
    bookingController = BookingController.create();
  }

  public static void main(String[] args) {
    UserInterface t = new UserInterface();
    t.greetUser();
    t.chooseCommand();
  }

  private void chooseCommand() {
    do {
      showCommands();
      String comm = scanner.nextLine();
      try {
        System.out.println(comm);
        CommandList command = CommandParser.parse(comm);
        switch (command) {
          case ONLINE_BOARD:
            FlightCommands.printAllFlights(flightController);
            break;
          case SHOW_FLIGHT_INFO: /*showFlightInfo()*/
            FlightCommands.printDetailedFlight(flightController, scanner);
            break;
          case SEARCH_AND_BOOK_FLIGHT: /*searchAndBookFlight*/
            break;
          case CANCEL_BOOKING: /*cancelBooking()*/
            break;
          case MY_BOOKINGS: /*myBookings()*/
            UserBookingCommands.showMyBookings(userController, bookingController);
            break;
          case END_SESSION: /*endSession()*/
            break;
          case HELP: /*Help*/
            break;
          case EXIT:
            System.exit(0);
            break;
        }
      } catch (Exception e) {
        System.out.println("Command not found please try again");
      }
    } while (true);
  }

  private void showCommands() {
    System.out.println("So choose a command from: ");
    for (int i = 0; i < CommandParser.showCommands().length; i++) {
      System.out.println((i + 1) + ") " + CommandParser.showCommands()[i]);
    }
  }

  private void loginUser() {
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
      loginUser();
    }
  }

  private void registerUser() {
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

  private void greetUser() {
    System.out.println(flightController.getAllFlights().size());
    if (flightController.getAllFlights().size() < 3) {
      FlightCommands.generateDatabase(flightController, scanner);
    }

    System.out.println("Hello and welcome to our Flight booking app");
    System.out.println("Do you have an account?");
    String answer = scanner.nextLine();
    switch (answer.toLowerCase()) {
      case "yes":
        loginUser();
        break;
      case "no":
        registerUser();
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + answer.toLowerCase());
    }
  }
}
