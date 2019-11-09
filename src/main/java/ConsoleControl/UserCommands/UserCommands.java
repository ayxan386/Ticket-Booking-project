package ConsoleControl.UserCommands;

import Booking.Booking;
import Booking.BookingController;
import User.User;
import User.UserController;

import java.util.Optional;

public class UserCommands {
  public static void showMyBookings(UserController userController, BookingController bookingController) {
    Optional<User> loggedUser = userController.getLoggedUser();
    if (loggedUser.isPresent()) {
      for (String bookingId : loggedUser.get().getBookings()) {
        Booking b = bookingController.get(bookingId);
        System.out.println(b);
      }
    }
  }
}
