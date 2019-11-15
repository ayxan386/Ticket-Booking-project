package flight;

import java.util.Set;

public class FlightController {

  private final FlightService flightService;

  private FlightController() {
    this.flightService = new FlightService();
  }

  public static FlightController create() {
    return new FlightController();
  }

  public Flight getFlightInfo(String id) {
    return flightService.get(id);
  }

  public Set<Flight> getAllFlights() {
    return flightService.getALLData();
  }

  public boolean addFlight(Flight f) {
    return flightService.smartAdd(f);
  }

  public Flight findFlightFromTo(String from, String to) {
    return flightService.findFromTo(from, to);
  }

  public void eraseAll() {

    flightService.eraseData();

  }

  public void update(Flight f) {
    flightService.update(f);
  }

  public Set<Flight> findFlightsFromTo(String from, String to) {
    return flightService.findFlightFromTo(from, to);
  }
}