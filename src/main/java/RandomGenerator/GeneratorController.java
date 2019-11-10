package RandomGenerator;

import Flight.Flight;
import Flight.FlightController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GeneratorController {
  private static final List<String> cities = Arrays.asList("Baku", "Kiev", "Moscow",
      "London", "Tokyo", "Paris",
      "Rome", "California", "Washington",
      "Switzerland");

  public void generateNewDataBase(FlightController flightController) {
    Random r = new Random();
    int total = r.nextInt(75) + 25;
    for (int i = 0; i < total; i++) {
      String from = cities.get(r.nextInt(cities.size()));
      String to = cities.get(r.nextInt(cities.size()));
      if (from.equals(to)) continue;
      double duration = r.nextDouble() * 23 * 60;
      Flight flight = new Flight(from, to, duration);
      flightController.addFlight(flight);
    }
  }
}
