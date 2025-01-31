package org.example.model;

public interface PriorityQueue {
    int getFist();
    int getPriority();
    boolean isEmpty();
    void remove();
    void add(int value, int priority);
}
