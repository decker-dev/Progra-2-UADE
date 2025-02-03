package org.example.model;

public class StaticStack implements Stack {

    private final List internalList;

    public StaticStack() {
        this.internalList = new StaticList();
    }

    @Override
    public int getTop() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }
        return internalList.get(internalList.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public void add(int element) {
        internalList.add(element);
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desapilar de una pila vacía");
        }
        internalList.remove(internalList.size() - 1);
    }
}