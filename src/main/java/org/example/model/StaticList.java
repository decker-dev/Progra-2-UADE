package org.example.model;

public class StaticList implements List {
    private static final int MAX = 10000;
    private final int[] array;
    private int count;

    public StaticList() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public void add(int element) {
        // Pre: count < MAX
        // Post: Se agrega el elemento al final.
        if (count >= MAX) {
            throw new RuntimeException("Lista llena");
        }
        array[count] = element;
        count++;
    }

    @Override
    public int get(int index) {
        // Pre: 0 <= index < count
        // Post: Retorna el elemento en la posición index.
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        return array[index];
    }

    @Override
    public void set(int index, int element) {
        // Pre: 0 <= index < count
        // Post: Se reemplaza el elemento en la posición index por element.
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        array[index] = element;
    }

    @Override
    public void remove(int index) {
        // Pre: 0 <= index < count
        // Post: Se elimina el elemento en index y se desplazan los elementos posteriores.
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    @Override
    public int size() {
        return count;
    }
}