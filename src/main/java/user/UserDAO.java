package user;

import dao.DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDAO implements DAO<User> {

  private final static File users = new File("data", "users.txt");
  private List<User> storage;

  public UserDAO() {
    storage = new ArrayList<User>();
    loadAllUser();
  }

  public void loadAllUser() {
    try {
      BufferedReader br = new BufferedReader(
          new FileReader(users));
      br.lines().forEach(row -> {
        String[] columns = row.split("/");
        String bookingsJoined = columns[5];

        bookingsJoined = bookingsJoined.replace("[,", "")
            .replace("[", "")
            .replace("]", "");

        List<String> bookings = Arrays.asList(bookingsJoined.split(","));

        User temp = new User(columns[0], columns[1], columns[2], columns[4]);
        bookings.forEach(temp::addBooking);

        storage.add(temp);
      });
      br.close();
    } catch (Exception e) {
      //...
    }
  }

  public void updateDatabase() {
    try {
      BufferedWriter bw = new BufferedWriter(
          new FileWriter(users));
      for (User user : storage) {
        bw.write(
            String.format("%s/%s/%s/%s/%s/%s\n",
                user.getName(),
                user.getSurname(),
                user.getNickname(),
                user.getId(),
                user.getPassword(),
                user.bookingToString()
            ));
      }
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void add(User data) {
    storage.add(data);
    updateDatabase();
  }

  @Override
  public void remove(String id) {
    storage.removeIf(el -> el.getId().equals(id));
    updateDatabase();
  }

  @Override
  public User get(String id) {
    return storage.stream()
        .filter(el -> el.getId().equals(id))
        .findFirst().get();
  }

  @Override
  public void update(User data) {
    storage.remove(data);
    storage.add(data);
    updateDatabase();
  }


  public boolean contains(User data) {
    return storage.contains(data);
  }

  public void eraseData() {
    try {
      BufferedWriter bw = new BufferedWriter(
          new FileWriter(users));
      bw.write("");
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
