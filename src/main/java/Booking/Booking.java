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
  private String ID;
  private boolean Class;

  public Booking(Flight flight, LocalDateTime date, String price, String ID, boolean aClass) {

    this.flight = flight;
    this.date = date;
    this.price = price;
    this.ID = ID;
    this.Class = aClass;
  }

  public Booking(Flight flight, LocalDateTime date, String price, boolean aClass) {
    this.flight = flight;
    this.date = date;
    this.price = price;
    this.ID = randomId();
    Class = aClass;
  }

  public Booking() {

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Booking)) return false;
    Booking booking = (Booking) o;
    return Objects.equals(getID(), booking.getID());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getID());
  }

  public boolean isClass() {
    return Class;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public void setClass(boolean aClass) {
    Class = aClass;
  }

  public String getID() {
    return ID;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public String getPrice() {
    return price;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public Flight getFlight() {
    return flight;
  }

  private String randomId() {
    return Stream.generate(() -> String.valueOf((char) (Math.random() * 36)))
        .limit(10)
        .collect(Collectors.joining(""));
  }
}
