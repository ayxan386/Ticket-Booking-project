package consoleControl.FlightCommands;

import consoleControl.Printer.FancyString.FancyString;
import consoleControl.Printer.Printer;
import flight.Flight;
import flight.FlightController;
import randomGenerator.GeneratorController;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlightCommands {
  public static void printAllFlights(FlightController flightController) {
    List<FancyString> allFlights = flightController.getAllFlights()
        .stream()
        .map(el -> (FancyString) el)
        .collect(Collectors.toList());
    Printer.print(allFlights);
  }

  public static void printDetailedFlight(FlightController flightController, Scanner scanner) {
    System.out.println("What is the ID of the flight?");
    System.out.println("(to exit enter 0 or exit)");
    String id = scanner.nextLine();
    if (id.equalsIgnoreCase("exit") || id.equalsIgnoreCase("0")) return;
    Flight flightInfo = flightController.getFlightInfo(id);
    System.out.println(flightInfo.detailedString());
  }

  public static void generateDatabase(FlightController flightController, Scanner scanner) {
    System.out.println("You don't have a database properly setup");
    System.out.println("Would you like us to make a new one?(yes/no)");
    String ans = scanner.nextLine();
    switch (ans.toLowerCase()) {
      case "yes":
        new GeneratorController().generateNewDataBase(flightController);
        break;
      case "no":
        return;
    }
  }
}
