package Flight;

import DAO.DAO;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FlightDAO implements DAO<Flight> {

  private final static File flights = new File("data", "flights.txt");
  private Set<Flight> storage;

  public FlightDAO() {
    storage = loadDataBase();
  }

  private Set<Flight> loadDataBase() {
    HashSet<Flight> res = new HashSet<Flight>();
    try {
      BufferedReader bw = new BufferedReader(
          new FileReader(flights));
      bw.lines().forEach(el -> {
        String[] cols = el.split("/");
        System.out.println(Arrays.toString(cols));
        Flight f = new Flight(cols[0], cols[1], cols[2], Double.parseDouble(cols[3]));
        res.add(f);
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
          new FileWriter(flights));
      for (Flight flight : storage) {
        bw.write(
            String.format("%s/%s/%s/%s\n",
                flight.getId(),
                flight.getFrom(),
                flight.getTo(),
                String.valueOf(flight.getDuration())
            ));
      }
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void add(Flight data) {
    storage.add(data);
    updateDatabase();
  }

  @Override
  public void remove(String id) {
    storage.removeIf(el -> el.getId().equals(id));
    updateDatabase();
  }

  @Override
  public Flight get(String id) {
    return storage.stream()
        .filter(el -> el.getId().equals(id))
        .findFirst().get();
  }

  public Set<Flight> getAllData() {
    return storage;

  }

  public Flight findFromTo(String form, String to) {
    return storage.stream().filter(t -> form.equals(t.getFrom()) ||
        to.equals(t.getTo())).findFirst().get();

  }

  @Override
  public void update(Flight data) {
    storage.add(data);
  }


  public boolean contains(Flight data) {
    return storage.contains(data);
  }

  public void eraseData() {
    try {
      BufferedWriter bw = new BufferedWriter(
          new FileWriter(flights));
      bw.write("");
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}