package Booking;

import DAO.DAO;
import Flight.Flight;

import java.awt.print.Book;
import java.io.*;
import java.util.HashSet;

public class BookingDAO implements DAO<Booking> {

  private final static File bookings = new File("data", "bookings.txt");
  private HashSet<Booking> storage;

  public BookingDAO() {
    storage =  loadDataBase();
  }

  private HashSet<Booking> loadDataBase() {
    HashSet<Booking> res = new HashSet<>();
    try {
      BufferedReader bw = new BufferedReader(
              new FileReader(bookings));
      bw.lines().forEach(el -> {
        String[] cols = el.split("/");
        Booking booking = new Booking(cols[1]);
        res.add(booking);
      });
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return res;
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
    if (storage.isEmpty()) System.out.println("Booking Info is empty");
    return storage;
  }
}
