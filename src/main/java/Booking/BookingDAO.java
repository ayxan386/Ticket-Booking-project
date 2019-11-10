package Booking;

import DAO.DAO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class BookingDAO implements DAO<Booking> {

  private final static File bookings = new File("data", "bookings.txt");
  private HashSet<Booking> storage;

  public BookingDAO() {
    storage = new HashSet<Booking>();
  }

  public void updateDatabase() {
    try {
      BufferedWriter bw = new BufferedWriter(
          new FileWriter(bookings));
      for (Booking bookings : storage) {
        bw.write(
            String.format("%s/%s/%s/%s/%s\n",
                bookings.getFlight(),
                bookings.getID(),
                bookings.getDate(),
                bookings.getPrice(),
                bookings.getClass()
            ));
      }
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
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

  public HashSet<Booking> getAllBookingInfo() {
    return storage;
  }
}
