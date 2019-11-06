package Flight;


import java.util.ArrayList;

public class FlightController {

    private final FlightService flightService;

    private FlightController() {
        this.flightService = new FlightService();
    }

    public Flight getFlightInfo(String id) {

        Flight info = new Flight();
        info.setId(id);
        info.setFrom(flightService.get(id).getFrom());
        info.setTo(flightService.get(id).getTo());
        info.setDuration(flightService.get(id).getDuration());

        return info;
    }





//    public ArrayList<Flight> getAllFlights(Flight flight) {
//        Flight temp = flightService.get(flight.getId());
//        return new ArrayList<Flight>() {{
//            add(temp.getFrom());
//            add(temp.getTo());
//            add(Double.toString(temp.getDuration()));
//            add(temp.getId());
//        }};
//    }




    public boolean addFlight(Flight f) {
        throw new IllegalArgumentException("Not implemented yet");
    }










    public Flight findFlightFromTo(String from, String to) {
        return flightService.findFromTo(from,to);
    }










    public static FlightController create() {
        return new FlightController();
    }








    public void eraseAll() {

        flightService.eraseData();

    }
}
