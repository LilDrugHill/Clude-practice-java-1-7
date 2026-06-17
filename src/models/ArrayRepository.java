package models;

import intefaces.Repository;

import java.util.Arrays;

public class ArrayRepository<T> implements Repository<T> {
    private T[] elements;
    private int size;

    @SuppressWarnings(value = "unchecked")
    public ArrayRepository(int size) {
        elements = (T[]) new Object[size];
        this.size = size;
    }
    @Override
    public void add(T element) {
        if (element == null) { return; }
        int counter = 0;
        while (elements[counter++] != null) {
            if (counter == size) {
                resizeArray();
            }
        }
        elements[counter] = element;
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
        this.size *= 2;
        this.elements = Arrays.copyOf(this.elements, this.size);
    }

}
