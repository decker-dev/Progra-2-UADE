package org.example;

import org.example.model.Queue;
import org.example.model.StaticQueue;


public class App {

    public static void main(String[] args) {
        Queue queue = new StaticQueue();
        queue.add(1);
    }

}