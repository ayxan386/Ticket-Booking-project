package Flight;

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

    Flight info = new Flight();
    info.setId(id);
    info.setFrom(flightService.get(id).getFrom());
    info.setTo(flightService.get(id).getTo());
    info.setDuration(flightService.get(id).getDuration());

    return info;
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
}