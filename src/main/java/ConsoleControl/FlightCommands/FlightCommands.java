package ConsoleControl.FlightCommands;

import ConsoleControl.Printer.FancyString.FancyString;
import ConsoleControl.Printer.Printer;
import Flight.Flight;
import Flight.FlightController;

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
    System.out.println("What is the ID of the flight");
    Flight flightInfo = flightController.getFlightInfo(scanner.nextLine());
    System.out.println(flightInfo.fancyString());
  }
}
