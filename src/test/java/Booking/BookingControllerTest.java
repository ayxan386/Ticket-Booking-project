package Booking;

import Flight.Flight;
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
                f = new Flight();
                b1 = new Booking(f, LocalDateTime.now(), "99.65", "000001", false);
                b2 = new Booking(f, LocalDateTime.now(), "199.65", "000002", true);
        }

        @Test
        public void bookNewFlight() {
                boolean res = bookingController.add(b1);
                boolean expected = true;
                assertThat(res, equalTo(expected));
        }

        @Test
        public void registerAlreadyExistingUser() {
                boolean res = bookingController.add(b1);
                boolean expected = false;
                assertThat(res, equalTo(expected));
        }

        @Test
        public void getBookingByID() {
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