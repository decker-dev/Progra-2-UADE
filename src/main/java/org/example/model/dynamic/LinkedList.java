package org.example.model.dynamic;

import org.example.model.dynamic.nodes.Node;

public class LinkedList implements List {

    private Node first;

    public LinkedList() {
        this.first = null;
    }

    @Override
    public void add(int element) {
        // I dont have a node
        if (this.first == null){
            this.first = new Node(element, null);
            return;
        }
        // I have a first node
        if (this.first.getNext() == null){
            this.first.setNext(new Node(element, null));
            return;
        }
        // I have more than one node
        Node candidate = this.first.getNext();
        while (this.first.getNext() != null){
            candidate = candidate.getNext();
        }
        candidate.setNext(new Node(element, null));
    }

    @Override
    public void remove() {
        if (this.first == null){
            throw new RuntimeException("Empty list");
        }
        if (this.first.getNext() == null){
            this.first = null;
            return;
        }
        Node backup = this.first;
        Node candidate = this.first.getNext();
        while (candidate.getNext() != null){
            backup = candidate;
            candidate = candidate.getNext();
        }
        backup.setNext(null);

    }

    @Override
    public int length() {
        if (this.first == null){
            return 0;
        }
        int count = 1;
        Node candidate = this.first;
        while (candidate.getNext() != null){
            count++;
            candidate = candidate.getNext();
        }
        return count;
    }

    @Override
    public int get(int index) {
        if (index < 0){
            throw new RuntimeException("Index dont have to be negative");
        }
        int size = length();
        if (index >= size){
            throw new RuntimeException("Index out of bounds");
        }
        if (index == 0){
            return this.first.getValue();
        }
        Node candidate = this.first.getNext();
        for (int i = 0; i < index; i++){
            candidate = candidate.getNext();
        }
        return candidate.getValue();
    }
}
