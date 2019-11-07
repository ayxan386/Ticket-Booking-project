package DAO;

public interface DAO <T> {
    void add(T data);

    void remove(String id);

    T get(String id);

    void update(T data);
}
