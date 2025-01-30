package org.example.model;

public class StaticQueue implements Queue{

    private static final int MAX = 10000;

    private final int[] array;
    private int count;

    public StaticQueue() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public int getFist() {
        if (this.isEmpty()) {
            throw new RuntimeException("Don't get the first element of an empty queue");
        }
        return this.array[0];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public void add(int value) {
        this.array[count] = value;
        this.count++;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("Don't remove an element from an empty queue");
        }
        for (int i = 0; i < this.count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.count--;

    }


}
