package ConsoleControl;

import Booking.BookingController;
import ConsoleControl.FlightCommands.FlightCommands;
import ConsoleControl.UserCommands.UserAccountCommands;
import ConsoleControl.UserCommands.UserBookingCommands;
import Flight.FlightController;
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
    UserAccountCommands.greetUser(t.userController, t.flightController, t.scanner);
    t.chooseCommand();
  }

  private void chooseCommand() {
    do {
      showCommands();
      String comm = scanner.nextLine();
      try {
        CommandList command = CommandParser.parse(comm);
        switch (command) {
          case ONLINE_BOARD:
            FlightCommands.printAllFlights(flightController);
            break;
          case SHOW_FLIGHT_INFO:
            FlightCommands.printDetailedFlight(flightController, scanner);
            break;
          case SEARCH_AND_BOOK_FLIGHT:
            UserBookingCommands.bookNewFlight(userController, bookingController, flightController, scanner);
            break;
          case CANCEL_BOOKING:
            UserBookingCommands.cancelBookings(userController, bookingController, flightController, scanner);
            break;
          case MY_BOOKINGS:
            UserBookingCommands.showMyBookings(userController, bookingController);
            break;
          case END_SESSION:
            userLogOut();
            break;
          case HELP:
            help();
            break;
          case EXIT:
            System.exit(0);
            break;
        }
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Command not found please try again");
      }
    } while (true);
  }

  private void help() {
    System.out.println("If you need any help these are our contacts:");
    System.out.println("Email:\n help@corps.com\n ");
    System.out.println("Phone:\n +994446667557\n ");
  }

  private void userLogOut() {
        System.out.println("Okay good bye");
        UserInterface userInterface = new UserInterface();
        UserAccountCommands.greetUser(userInterface.userController,userInterface.flightController,userInterface.scanner);
        userInterface.chooseCommand();
      }

private void showCommands() {
    System.out.println("Choose a command from: ");
    for (int i = 0; i < CommandParser.showCommands().length; i++) {
      System.out.println((i + 1) + ") " + CommandParser.showCommands()[i]);
    }
  }
}
