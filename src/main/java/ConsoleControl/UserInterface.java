package ConsoleControl;

import Booking.BookingController;
import ConsoleControl.Printer.Printer;
import FancyString.FancyString;
import Flight.FlightController;
import User.User;
import User.UserController;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
                t.showCommands();
                t.chooseCommand();
        }

        private void chooseCommand() {
                do {
                        String comm = scanner.nextLine();
                        CommandList command = CommandParser.parse(comm);
                        switch (command) {
                                case ONLINE_BOARD:
                                        printAllFlights();
                                        break;
                                case SHOW_FLIGHT_INFO: /*showFlightInfo()*/
                                        printDetailedFlight();
                                        break;
                                case SEARCH_AND_BOOK_FLIGHT: /*searchAndBookFlight*/
                                        break;
                                case CANCEL_BOOKING: /*cancelBooking()*/
                                        break;
                                case MY_BOOKINGS: /*myBookings()*/
                                        break;
                                case END_SESSION: /*endSession()*/
                                        break;
                                case HELP: /*Help*/
                                        break;
                                case EXIT:
                                        System.exit(0);
                                        break;
                        }
                } while (true);
        }

        private void printDetailedFlight() {
                System.out.println("What is the ID of the flight");
                String flightInfo = flightController.getFlightInfo(scanner.nextLine());
                System.out.println(flightInfo);
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

        private void printAllFlights() {
                List<FancyString> allFlights = flightController.getAllFlights()
                        .stream()
                        .map(el -> (FancyString) el)
                        .collect(Collectors.toList());
                Printer.print(allFlights);
        }
}
