package Booking;

import DAO.DAO;
import Flight.Flight;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BookingDAO implements DAO<Booking> {

  private final static File bookings = new File("data", "bookings.txt");
  private Set<Booking> storage;

  public BookingDAO() {
    storage = loadDataBase();
  }

  public void updateDatabase() {
    try {
      BufferedWriter bw = new BufferedWriter(
          new FileWriter(bookings));
      for (Booking bookings : storage) {
        bw.write(
            String.format("%s/%s\n",
                bookings.getID(),
                bookings.getFlight()
            ));
      }
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private Set<Booking> loadDataBase() {
    HashSet<Booking> res = new HashSet<Booking>();
    try {
      BufferedReader bw = new BufferedReader(
          new FileReader(bookings));
      bw.lines().forEach(el -> {
        String[] cols = el.split("/");
        Booking b = new Booking(Flight.stringToFlight(cols[0]), cols[2]);
        res.add(b);
      });
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return res;
  }

  @Override
  public void add(Booking data) {
    storage.add(data);
    updateDatabase();
  }

  @Override
  public void remove(String id) {
    storage.removeIf(el -> el.getID().equals(id));
    updateDatabase();
  }

  @Override
  public Booking get(String id) {
    return storage.stream()
        .filter(el -> el.getID().equals(id))
        .findFirst().get();
  }

  @Override
  public void update(Booking data) {
    storage.add(data);
  }


  public boolean contains(Booking data) {
    return storage.contains(data);
  }

  public void eraseData() {
    try {
      BufferedWriter bw = new BufferedWriter(
          new FileWriter(bookings));
      bw.write("");
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Set<Booking> getAllBookingInfo() {
    return storage;
  }
}
