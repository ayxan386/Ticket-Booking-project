package ConsoleControl.UserCommands;

import Booking.Booking;
import Booking.BookingController;
import Flight.Flight;
import Flight.FlightController;
import User.User;
import User.UserController;

import java.util.Optional;
import java.util.Scanner;

public class UserBookingCommands {
  public static void showMyBookings(UserController userController, BookingController bookingController) {
    Optional<User> loggedUser = userController.getLoggedUser();
    if (loggedUser.isPresent()) {
      System.out.println("List of your bookings");
      for (String bookingId : loggedUser.get().getBookings()) {
        Booking b = bookingController.get(bookingId);
        System.out.println(b.toDetailedString());
      }
    } else {
      System.out.println("You have no bookings(");
    }
  }

  public static void cancelBookings(UserController userController, BookingController bookingController, Scanner scanner) {
    Optional<User> loggedUser = userController.getLoggedUser();
    if (loggedUser.isPresent()) {
      showMyBookings(userController, bookingController);

      System.out.println("Which booking would you like to cancel? (Enter its id)");
      String id = scanner.nextLine();
      User user = loggedUser.get();
      if (!user.hasBooking(id)) throw new IllegalArgumentException("No such booking exists");
      user.removeBooking(id);
      bookingController.remove(new Booking(id));
    } else {
      throw new IllegalArgumentException("You are not logged in");
    }
  }

  public static void bookNewFlight(UserController userController, BookingController bookingController, FlightController flightController, Scanner scanner) {
    System.out.println("Do you know the id of the flight?");
    String ans = scanner.nextLine();
    switch (ans.toLowerCase()) {
      case "yes":
        bookWithId(userController, bookingController, flightController, scanner);
        break;
      case "no":
        //bookWithoutId(userController, bookingController, flightController,scanner);
        break;
      default:
        throw new IllegalArgumentException("No such command found");
    }
  }

  private static void bookWithId(UserController userController, BookingController bookingController, FlightController flightController, Scanner scanner) {
    System.out.println("Please enter the id of the flight");
    String id = scanner.nextLine();
    System.out.println("How many tickets would you like to book?");
    int number = scanner.nextInt();
    scanner.nextLine();
    Flight f = flightController.getFlightInfo(id);
    if (f.getSeats() < number) {
      System.out.println("Sorry that flight does not have enough seats");
      return;
    }
    Booking b = new Booking(f, number);
    bookingController.add(b);

    User user = userController.getLoggedUser().get();
    user.addBooking(b);
    userController.update(user);

    f.bookSeat(number);

    flightController.update(f);

    System.out.println("You have successfully booked new flight");
    System.out.printf("ID of new booking: %s\n", b.getID());
  }
}
