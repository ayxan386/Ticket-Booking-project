package Flight;

import java.util.ArrayList;

public class FlightController {

        private final FlightService flightService;

        private FlightController() {
                this.flightService = new FlightService();
        }

        public String getFlightInfo(String id) {
                throw new IllegalArgumentException("Not implemented yet");
        }

        public ArrayList<Flight> getAllFlights() {
                throw new IllegalArgumentException("Not implemented yet");
        }

        public boolean addFlight(Flight f) {
                throw new IllegalArgumentException("Not implemented yet");
        }

        public Flight findFlightFromTo(String from, String to) {
                throw new IllegalArgumentException("Not implemented yet");
        }


        public static FlightController create() {
                return new FlightController();
        }

        public void eraseAll() {
                throw new IllegalArgumentException("Not implemented yet");
        }
}
