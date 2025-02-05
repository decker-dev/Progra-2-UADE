package org.example.model.Static;

public class StaticSet implements Set{
    private static final int MAX_CAPACITY = 10000;
    private final int[] elements;
    private int count;

    public StaticSet() {
        this.elements = new int[MAX_CAPACITY];
        this.count = 0;
    }

    @Override
    public void add(int element) {
        if (count >= MAX_CAPACITY) {
            throw new RuntimeException("Conjunto lleno");
        }
        for (int i = 0; i < count; i++) {
            if (elements[i] == element) {
                return;
            }
        }
        elements[count] = element;
        count++;
    }

    @Override
    public void remove(int element) {
        for (int i = 0; i < count; i++) {
            if (elements[i] == element) {
                elements[i] = elements[count - 1];
                count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if (isEmpty()) {
            throw new RuntimeException("Conjunto vacío");
        }
        return elements[(int) (Math.random() * count)];
    }
}
