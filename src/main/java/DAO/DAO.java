package DAO;

public interface DAO <T> {
    void add(T data);
    void remove (int id);
    T get (int id);
    void update (T data,int date,int number);
}
