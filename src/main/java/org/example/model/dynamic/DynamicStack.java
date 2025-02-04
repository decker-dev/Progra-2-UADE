package org.example.model.dynamic;

import org.example.model.Static.Stack;
import org.example.model.dynamic.nodes.Node;

public class DynamicStack implements Stack {
    private Node top;

    @Override
    public int getTop() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }
        return this.top.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public void add(int element) {
        this.top = new Node(element, this.top);
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }
        this.top = this.top.getNext();
    }
}
