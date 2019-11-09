package Flight;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FlightControllerTest {
        private FlightController flightController;
        private Flight f1;
        private Flight f2;

        @Before
        public void setup() {
                flightController = FlightController.create();
                f1 = new Flight("000001", "Baku", "Kiev", 2.5);
                f2 = new Flight("000002", "Hell", "Heaven", 666);
        }

        @After
        public void tearDown() throws Exception {
                flightController.eraseAll();
        }

        @Test
        public void addFlight() {
                boolean res = flightController.addFlight(f1);
                boolean expected = true;
                assertThat(res, equalTo(expected));
        }

        @Test
        public void addExistingFlight() {
                flightController.addFlight(f1);
                boolean res = flightController.addFlight(f1);
                boolean expected = false;
                assertThat(res, equalTo(expected));
        }

        @Test
        public void getFlightInfo() {
                flightController.addFlight(f1);
                String res = flightController.getFlightInfo(f1.getId());
                String expected = "from Baku to Kiev";
                assertThat(res, equalToIgnoringCase(expected));
        }

        @Test
        public void getNonExistingFlightInfo() {
                flightController.addFlight(f1);
                try {
                        String res = flightController.getFlightInfo(f2.getId());
                } catch (Exception e) {
                        String mess = e.getMessage();
                        assertThat(mess, equalToIgnoringCase("User not found"));
                }
        }

        @Test
        public void getAllFlights() {
                flightController.addFlight(f1);
                ArrayList<Flight> allFlights = flightController.getAllFlights();
                assertThat(allFlights, hasItem(f1));
                assertThat(allFlights, not(hasItem(f2)));
        }

        @Test
        public void findFlightFromTo() {
                flightController.addFlight(f1);
                Flight res = flightController.findFlightFromTo(f1.getFrom(), f1.getTo());
                assertThat(res, equalTo(f1));
        }
}