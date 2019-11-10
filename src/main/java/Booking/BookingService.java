package Booking;

import java.util.HashSet;

class BookingService {
  private BookingDAO bookingDAO;

  public BookingService(BookingDAO bookingDAO) {
    this.bookingDAO = bookingDAO;
  }

  public BookingService() {
    this.bookingDAO = new BookingDAO();
  }

  public boolean smartAdd(Booking data) {
    if (bookingDAO.contains(data)) return false;
    bookingDAO.add(data);
    return true;
  }

  public boolean smartRemove(Booking data) {
    if (bookingDAO.contains(data)) {
      bookingDAO.remove(data.getID());
      return true;
    }
    return false;
  }

  public void eraseData() {
    bookingDAO.eraseData();
  }

  public Booking get(String id) {
    return bookingDAO.get(id);
  }

  public void update(Booking data) {
    bookingDAO.update(data);
  }

  public HashSet<Booking> getAllBookingInfo() {
    return bookingDAO.getAllBookingInfo();
  }

}
