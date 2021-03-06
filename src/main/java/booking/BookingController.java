package booking;

public class BookingController {
  private final BookingService bookingService;

  private BookingController() {
    this.bookingService = new BookingService();
  }

  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  public static BookingController create() {
    return new BookingController();
  }

  public Booking get(String id) {
    return bookingService.get(id);
  }

  public boolean add(Booking book) {
    return bookingService.smartAdd(book);
  }

  public void eraseAll() {
    bookingService.eraseData();
  }

  public boolean remove(Booking book) {
    return bookingService.smartRemove(book);
  }

}
