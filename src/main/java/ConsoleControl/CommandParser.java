package ConsoleControl;

public class CommandParser {

  public static CommandList[] showCommands() {
    CommandList[] commands = CommandList.values();
    return commands;
  }

  public static CommandList parse(String command) {
    command = command.toUpperCase();
    switch (command) {
      case "ONLINE BOARD":
      case "1":
        return CommandList.ONLINE_BOARD;
      case "SHOW FLIGHT INFO":
      case "2":
        return CommandList.SHOW_FLIGHT_INFO;
      case "SEARCH AND BOOK FLIGHT":
      case "3":
        return CommandList.SEARCH_AND_BOOK_FLIGHT;
      case "CANCEL BOOKING":
      case "4":
        return CommandList.CANCEL_BOOKING;
      case "MY BOOKINGS":
      case "5":
        return CommandList.MY_BOOKINGS;
      case "END SESSION":
      case "6":
        return CommandList.END_SESSION;
      case "HELP":
      case "7":
        return CommandList.HELP;
      case "EXIT":
      case "8":
        return CommandList.EXIT;
      default:
        throw new IllegalArgumentException("Command not found");
    }
  }


}
