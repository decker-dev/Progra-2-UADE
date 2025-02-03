package org.example.model;

public class StaticStack implements Stack {

    private List list;

    public StaticStack() {
        this.list = new StaticList();
    }

    @Override
    public int getTop() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }
        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void add(int a) {
        list.add(a);
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desapilar de una pila vacía");
        }
        list.remove(list.size() - 1);
    }
}