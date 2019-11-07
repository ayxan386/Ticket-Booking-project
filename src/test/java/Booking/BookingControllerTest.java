package Booking;

import Flight.Flight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class BookingControllerTest {
        private BookingController bookingController;
        private Booking b1;
        private Booking b2;
        private Flight f;

        @Before
        public void setup() {
                bookingController = BookingController.create();
                f = new Flight("00001", "Baku", "Kiev", 2.5);
                b1 = new Booking(f, LocalDateTime.now(), "99.65", "000001", false);
                b2 = new Booking(f, LocalDateTime.now(), "199.65", "000002", true);
        }

        @After
        public void tearDown() throws Exception {
                bookingController.eraseAll();
        }

        @Test
        public void bookNewFlight() {
                boolean res = bookingController.add(b1);
                boolean expected = true;
                assertThat(res, equalTo(expected));
        }

        @Test
        public void bookAlreadyFlight() {
                bookingController.add(b1);
                boolean res = bookingController.add(b1);
                boolean expected = false;
                assertThat(res, equalTo(expected));
        }

        @Test
        public void getBookingByID() {
                bookingController.add(b1);
                Booking res = bookingController.get(b1.getSerialNumber());
                assertThat(res, equalTo(b1));
        }

        @Test
        public void getBookingByIDNonExisting() {
                try {
                        Booking res = bookingController.get(b2.getSerialNumber());
                } catch (Exception e) {
                        assertThat(e.getMessage(), containsString("No such element found"));
                }
        }

        @Test
        public void removeUser() {
                bookingController.add(b1);
                boolean res = bookingController.remove(b1);
                boolean expected = true;
                assertThat(res, equalTo(expected));
        }

        @Test
        public void removeUserNonExisting() {
                boolean res = bookingController.remove(b2);
                boolean expected = false;
                assertThat(res, equalTo(expected));
        }

}