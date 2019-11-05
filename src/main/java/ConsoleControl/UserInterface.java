package ConsoleControl;

import User.User;

import java.util.Scanner;

public class UserInterface {
        public static void main(String[] args) {
                UserInterface t = new UserInterface();
                t.greetUser();
                t.showCommands();
                t.chooseCommand();
        }

        private void chooseCommand() {
                Scanner scanner = new Scanner(System.in);
                do {
                        int temp = scanner.nextInt();
                        switch (temp - 1) {
                                case 0: /*showOnlineTable()*/
                                        break;
                                case 1: /*showFlightInfo()*/
                                        break;
                                case 2: /*searchAndBookFlight*/
                                        break;
                                case 3: /*cancelBooking()*/
                                        break;
                                case 4: /*myFlights()*/
                                        break;
                                case 5: /*myBookings()*/
                                        break;
                                case 6: /*endSession()*/
                                        break;
                                case 7: /*Help*/
                                        break;
                                case 8:
                                        System.exit(0);
                                        break;
                                default:
                                        System.out.println("Error");
                        }
                } while (true);
        }

        private void showCommands() {
                System.out.println("So nice.So choose a command from: ");
                for (int i = 0; i < CommandParser.showCommands().length; i++) {
                        System.out.println((i + 1) + ") " + CommandParser.showCommands()[i]);
                }
        }

        private void loginUser() {

        }

        private void registerUser() {
                System.out.println("  Please input all information about you:  ");
                Scanner scanner = new Scanner(System.in);
                String name, surname, nickname;
                System.out.print("Input name: ");
                name = scanner.nextLine();
                System.out.print("Input surname: ");
                surname = scanner.nextLine();
                System.out.print("Input your nickname: ");
                nickname = scanner.nextLine();
                User user = new User(name, surname, nickname);
        }

        private void greetUser() {
                registerUser();
                loginUser();
        }

}
