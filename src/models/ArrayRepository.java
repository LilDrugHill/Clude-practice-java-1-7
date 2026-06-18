package models;

import intefaces.Repository;

import java.util.Arrays;

public class ArrayRepository<T> implements Repository<T> {
    private final int START_ARRAY_SIZE = 10;
    private T[] elements;
    private int size = 0;

    @SuppressWarnings(value = "unchecked")
    public ArrayRepository() {
        elements = (T[]) new Object[START_ARRAY_SIZE];
    }
    @Override
    public void add(T element) {
        if (element == null) { return; }
        if (size == elements.length) { resizeArray(); }
        elements[size++] = element;
    }

    @Override
    public T get(int id) {
        if(id >= size - 1 || id < 0) { throw new ArrayIndexOutOfBoundsException(); }
        return elements[id];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T[] toArray() {
        return elements;
    }

    private void resizeArray() {
        this.elements = Arrays.copyOf(this.elements, this.size * 2);
    }

}
