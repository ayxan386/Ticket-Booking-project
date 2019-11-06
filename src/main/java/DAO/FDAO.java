package DAO;

import Flight.Flight;

import java.util.ArrayList;

public interface FDAO <T> {
    void add(T data);

    void remove(String id);

    T get(String id);

    void update(T data);

    ArrayList<T> getAllData();

    T findFromTo(String form, String to);
}
