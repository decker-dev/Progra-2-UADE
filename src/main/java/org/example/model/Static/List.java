package org.example.model.Static;

public interface List {
    void add(int element);
    int get(int index);
    void set(int index, int element);
    void remove(int index);
    int size();
    boolean isEmpty();
}