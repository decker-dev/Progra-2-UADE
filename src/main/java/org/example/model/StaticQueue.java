package org.example.model;

public class StaticQueue implements Queue {
    private static final int MAX = 10000;
    private final int[] array;
    private int count;

    public StaticQueue() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return array[0];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void add(int a) {
        if (count >= MAX) {
            throw new RuntimeException("Cola llena");
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desencolar de una cola vacía");
        }
        for (int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }
}