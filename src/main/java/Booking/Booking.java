package Booking;

import Flight.Flight;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Booking {

  private final Flight flight;
  private final String ID;

  public Booking(Flight flight, String ID) {
    this.flight = flight;
    this.ID = ID;
  }

  public Booking(Flight flight) {
    this(flight, randomId());
  }

  public Booking(String id) {
    this(null, id);
  }

  private static String randomId() {
    return Stream.generate(() -> String.valueOf((char) (Math.random() * 26 + 'A')))
        .limit(10)
        .collect(Collectors.joining(""));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Booking)) return false;
    Booking booking = (Booking) o;
    return Objects.equals(getID(), booking.getID());
  }

  @Override
  public String toString() {
    return String.format("%s %s", ID, flight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getID());
  }

  public String getID() {
    return ID;
  }

  public Flight getFlight() {
    return flight;
  }

  public String toDetailedString() {
    return String.format("-------------------------------\n" +
        "<<<%s>>>\n %s\n" +
        "-------------------------------", ID, flight.detailedString());
  }
}
