package User;

import Booking.Booking;

import java.util.ArrayList;
import java.util.StringJoiner;

public class User {
  private final String name;
  private final String surname;
  private final String nickname;
  private final String id;
  private final String password;
  private final ArrayList<String> bookings;

  public User(String name, String surname, String nickname, String password) {
    this.name = name.toLowerCase();
    this.surname = surname.toLowerCase();
    this.nickname = nickname.toLowerCase();
    this.password = password;
    this.id = String.valueOf(nickname.hashCode());
    bookings = new ArrayList<>();
  }

  public User(User u, String password) {
    this(u.getName(), u.getSurname(), u.getNickname(), password);
  }

  public User(String name, String surname, String nickname) {
    this(name, surname, nickname, "");
  }

  public String getPassword() {
    return password;
  }

  public void addBooking(Booking b) {
    bookings.add(b.getID());
  }

  public void addBooking(String id) {
    bookings.add(id);
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getId() {
    return id;
  }

  public ArrayList<String> getBookings() {
    return bookings;
  }

  public boolean hasBooking(String id) {
    return bookings.contains(new Booking(id));
  }

  public void removeBooking(String id) {
    bookings.remove(new Booking(id));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return getId().equals(user.getId());
  }

  @Override
  public int hashCode() {
    return getId().hashCode();
  }

  @Override
  public String toString() {
    return String.format("User{name='%s', surname='%s', nickname='%s', id='%s'}", name, surname, nickname, id);
  }

  public String bookingToString() {
    StringJoiner res = new StringJoiner(",", "[", "]");
    bookings.forEach(res::add);
    return res.toString();
  }
}
