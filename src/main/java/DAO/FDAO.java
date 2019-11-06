package DAO;

public interface FDAO <T> {
    void add(T data);

    void remove(String id);

    T get(String id);

    void update(T data);

    T findFromTo(String form, String to);
}
