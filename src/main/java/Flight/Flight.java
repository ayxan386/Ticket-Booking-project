package Flight;

import ConsoleControl.Printer.FancyString.FancyString;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flight implements FancyString {
  private String id;
  private String from;
  private String to;
  private int seats;
  private double duration;
  private double price;

  public Flight(String id, String from, String to, int seats, double duration, double price) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.duration = duration;
    this.seats = seats;
    this.price = price;
  }

  public Flight(String from, String to, int seats, double duration, double price) {
    this.price = price;
    this.id = randomId();
    this.from = from;
    this.to = to;
    this.duration = duration;
    this.seats = seats;
  }

  public Flight() {

  }


  private String randomId() {
    return Stream.generate(() -> String.valueOf((char) ((int) (Math.random() * 26) + 'A')))
        .limit(10)
        .collect(Collectors.joining(""));
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public double getDuration() {
    return duration;
  }

  public void setDuration(double duration) {
    this.duration = duration;
  }

  public double getPrice() {
    return price;
  }

  public int getSeats() {
    return seats;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Flight)) return false;
    Flight flight = (Flight) o;
    return getId().equals(flight.getId());
  }

  @Override
  public String toString() {
    return String.format("{%s&%s&%s&%d&%f&%f}", id, from, to, seats, duration, price);
  }

  @Override
  public int hashCode() {
    return getId().hashCode();
  }

  @Override
  public String fancyString() {
    return String.format("<<%s>> %s ==> %s", getId(), getFrom(), getTo());
  }

  public static Flight stringToFlight(String str) {
    str = str.replace("{", "");
    str = str.replace("}", "");
    String[] data = str.split("&");
    return new Flight(data[0], data[1], data[2],
        Integer.parseInt(data[3]), Double.parseDouble(data[4]), Double.parseDouble(data[5]));
  }
}
