package Booking;

public class BookingController {
        private BookingService bookingService;

        public static BookingController create() {
                return new BookingController();
        }

        public boolean add(Booking b1) {
                throw new IllegalArgumentException("Not implemented yet");
        }

        public Booking get(String id) {
                throw new IllegalArgumentException("Not implemented yet");
        }

        public boolean remove(Booking booking) {
                throw new IllegalArgumentException("Not implemented yet");
        }

        public void eraseAll() {
                throw new IllegalArgumentException("Not implemented yet");
        }
}
