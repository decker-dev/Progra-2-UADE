package org.example.model.dynamic;

import org.example.model.Static.Queue;
import org.example.model.dynamic.nodes.Node;

public class DynamicQueue implements Queue {
    private Node first;

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primer elemento de una cola vacía");
        }
        return this.first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public void add(int element) {
        if (this.first == null) {
            this.first = new Node(element, null);
            return;
        }
        Node candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(new Node(element, null));
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desencolar de una cola vacía");
        }
        this.first = this.first.getNext();
    }
}
