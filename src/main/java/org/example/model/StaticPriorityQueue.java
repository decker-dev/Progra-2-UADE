package org.example.model;

public class StaticPriorityQueue implements PriorityQueue{
    private static final int MAX = 10000;
    private int[] values;
    private int[] priorities;
    private int count;
    public StaticPriorityQueue() {
        this.values = new int[MAX];
        this.priorities = new int[MAX];
        this.count = 0;
    }

    public int getFist() {
        if (this.isEmpty()) {
            throw new RuntimeException("Don't get the first element of an empty queue");
        }
        return this.values[0];
    }

    @Override
    public int getPriority() {
        if (this.isEmpty()) {
            throw new RuntimeException("Don't get the first element of an empty queue");
        }
        return this.priorities[0];
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("Don't remove an element from an empty queue");
        }
        for (int i = 0; i < this.count - 1; i++) {
            this.values[i] = this.values[i + 1];
            this.priorities[i] = this.priorities[i + 1];
        }
        this.count--;
    }

    @Override
    public void add(int value, int priority) {
        if (this.count == MAX) {
            throw new RuntimeException("The queue is full");
        }
        // ES EL PRIMERO
        if (this.isEmpty()) {
            this.values[0] = value;
            this.priorities[0] = priority;
            this.count++;
            return;
        }
        // ES EL QUE MENOR PRIORIDAD TIENE
        if (this.priorities[this.count - 1] <= priority) {
            this.values[this.count] = value;
            this.priorities[this.count] = priority;
            this.count++;
            return;
        }

        // ESTA AL FINAL
        if (this.priorities[0] > priority) {
            for (int i = this.count; i > 0; i--) {
                this.values[i] = this.values[i - 1];
                this.priorities[i] = this.priorities[i - 1];
            }
            this.values[0] = value;
            this.priorities[0] = priority;
            this.count++;
            return;
        }

        //EXISTE LA PRIORIDAD
        int index = this.findIndex(priority);

        if (index!=-1){
            int candidate= index;
            while (this.priorities[candidate] == priority) {
                candidate++;
            }
            for (int i = this.count; i > candidate; i--) {
                this.values[i] = this.values[i - 1];
                this.priorities[i] = this.priorities[i - 1];
            }
            this.values[candidate] = value;
            this.priorities[candidate] = priority;
            return;
        }

        //NO EXISTE LA PRIORIDAD
        int candidate = 0;
        while (this.priorities[candidate] > priority) {
            candidate++;
        }

        for (int i = this.count; i > candidate; i--) {
            this.values[i] = this.values[i - 1];
            this.priorities[i] = this.priorities[i - 1];
        }
        this.values[candidate] = value;
        this.priorities[candidate] = priority;
    }


    private int findIndex(int priority) {
        for (int i = 0; i < this.count; i++) {
            if (this.priorities[i] == priority) {
                return i;
            }
        }
        return -1;
    }
}
