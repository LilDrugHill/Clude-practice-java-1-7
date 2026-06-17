package intefaces;

public interface Repository<T> {
    void add(T object);
    T get(int id);
    int size();
    T[] toArray();
}
