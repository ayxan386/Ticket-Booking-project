package randomGenerator;

import flight.Flight;
import flight.FlightController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GeneratorController {
  private static final List<String> cities = Arrays.asList("Baku", "Kiev", "Moscow",
      "London", "Tokyo", "Paris",
      "Rome", "California", "Washington",
      "Switzerland", "OTTAWA", "BRASILIA",
      "HAVANA", "PRAGUE", "TBILISI",
      "BERLIN", "NEW DELHI", "TEHRAN");

  public void generateNewDataBase(FlightController flightController) {
    Random r = new Random();
    int total = r.nextInt(250) + 25;
    for (int i = 0; i < total; i++) {
      String from = cities.get(r.nextInt(cities.size()));
      String to = cities.get(r.nextInt(cities.size()));
      if (from.equals(to)) continue;
      double duration = r.nextDouble() * 23 * 60;
      double price = r.nextDouble() * 1000 + 150;
      int seats = r.nextInt(100) + 50;
      Flight flight = new Flight(from, to, seats, duration, price);
      flightController.addFlight(flight);
    }
  }
}
