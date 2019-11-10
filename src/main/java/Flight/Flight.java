package Flight;

import ConsoleControl.Printer.FancyString.FancyString;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flight implements FancyString {
  private String id;
  private  String from;
  private  String to;
  private  double duration;

  public Flight(String id, String from, String to, double duration) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.duration = duration;
  }

  public Flight(String from, String to, double duration) {
    this.id = randomId();
    this.from = from;
    this.to = to;
    this.duration = duration;
  }

  public Flight() {

  }


  private String randomId() {
    return Stream.generate(() -> String.valueOf((char) (Math.random() * 36)))
        .limit(10)
        .collect(Collectors.joining(""));
  }

  public String getId() {
    return id;
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }

  public double getDuration() {
    return duration;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public void setDuration(double duration) {
    this.duration = duration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Flight)) return false;
    Flight flight = (Flight) o;
    return getId().equals(flight.getId());
  }

  @Override
  public int hashCode() {
    return getId().hashCode();
  }


  @Override
  public String fancyString() {
    return String.format("<<%s>> %s ==> %s", getId(), getFrom(), getTo());
  }
}
