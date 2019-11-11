package ConsoleControl.UserCommands;

import Booking.Booking;
import Booking.BookingController;
import ConsoleControl.Printer.FancyString.FancyString;
import ConsoleControl.Printer.Printer;
import User.User;
import User.UserController;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserBookingCommands {
  public static void MyBookings (UserController userController,BookingController bookingController) {
    List<FancyString> allBookings = bookingController.getAllBookingInfo()
            .stream()
            .map(el -> (FancyString) el)
            .collect(Collectors.toList());
    Printer.print(allBookings);
  }


  public static void showMyBookings(UserController userController, BookingController bookingController) {
    Optional<User> loggedUser = userController.getLoggedUser();
    if (loggedUser.isPresent()) {
      for (String bookingId : loggedUser.get().getBookings()) {
        Booking b = bookingController.get(bookingId);
        System.out.println(b);
      }
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
}
