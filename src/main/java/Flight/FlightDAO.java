package Flight;

import DAO.FDAO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class FlightDAO implements FDAO<Flight> {

    private Set<Flight> storage;
    private final static File flights = new File("data", "flights.txt");
    public void updateDatabase() {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(flights));
            for (Flight flight : storage) {
                bw.write(
                        String.format("%s/%s/%s/%s/%s\n",
                                flight.getId(),
                                flight.getFrom(),
                                flight.getTo(),
                                flight.getDuration()
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
    @Override
    public ArrayList<Flight> getAllData() {
        ArrayList<Flight> allData = new ArrayList<Flight>();



        return allData;

    }

    @Override
    public Flight findFromTo(String form,String to) {
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
