package org.example.model;

public class StaticQueue implements Queue {
    private static final int MAX_CAPACITY = 10000;
    private final int[] elements;
    private int currentSize;

    public StaticQueue() {
        this.elements = new int[MAX_CAPACITY];
        this.currentSize = 0;
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primer elemento de una cola vacía");
        }
        return elements[0];
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public void add(int element) {
        if (currentSize >= MAX_CAPACITY) {
            throw new RuntimeException("Cola llena");
        }
        elements[currentSize] = element;
        currentSize++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desencolar de una cola vacía");
        }
        for (int pos = 0; pos < currentSize - 1; pos++) {
            elements[pos] = elements[pos + 1];
        }
        currentSize--;
    }
}