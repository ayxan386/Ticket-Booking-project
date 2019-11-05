package Booking;

import Flight.Flight;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Booking {
        private Flight flight;
        private LocalDateTime date;
        private String price;
        private String serialNumber;
        private boolean Class;

        public Booking(Flight flight, LocalDateTime date, String price, String serialNumber, boolean aClass) {
                this.flight = flight;
                this.date = date;
                this.price = price;
                this.serialNumber = serialNumber;
                Class = aClass;
        }

        public Booking(Flight flight, LocalDateTime date, String price, boolean aClass) {
                this.flight = flight;
                this.date = date;
                this.price = price;
                this.serialNumber = randomId();
                Class = aClass;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Booking)) return false;
                Booking booking = (Booking) o;
                return Objects.equals(getSerialNumber(), booking.getSerialNumber());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getSerialNumber());
        }

        public boolean isClass() {
                return Class;
        }

        public void setClass(boolean aClass) {
                Class = aClass;
        }

        public String getSerialNumber() {
                return serialNumber;
        }

        public void setSerialNumber(String serialNumber) {
                this.serialNumber = serialNumber;
        }

        public LocalDateTime getDate() {
                return date;
        }

        public void setDate(LocalDateTime date) {
                this.date = date;
        }

        public String getPrice() {
                return price;
        }

        public void setPrice(String price) {
                this.price = price;
        }

        private String randomId() {
                return Stream.generate(() -> String.valueOf((char) (Math.random() * 36)))
                        .limit(10)
                        .collect(Collectors.joining(""));
        }
}
