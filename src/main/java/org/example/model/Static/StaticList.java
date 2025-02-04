package org.example.model.Static;

public class StaticList implements List {
    private static final int MAX_CAPACITY = 10000;
    private final int[] elements;
    private int currentSize;

    public StaticList() {
        this.elements = new int[MAX_CAPACITY];
        this.currentSize = 0;
    }

    @Override
    public void add(int element) {
        if (currentSize >= MAX_CAPACITY) {
            throw new RuntimeException("Lista llena");
        }
        elements[currentSize] = element;
        currentSize++;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        return elements[index];
    }

    @Override
    public void set(int index, int element) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        elements[index] = element;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        for (int pos = index; pos < currentSize - 1; pos++) {
            elements[pos] = elements[pos + 1];
        }
        currentSize--;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }
}