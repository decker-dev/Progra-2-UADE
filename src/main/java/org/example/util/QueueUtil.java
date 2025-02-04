package org.example.util;

import org.example.model.Static.Queue;
import org.example.model.Static.StaticQueue;
import org.example.model.Static.List;
import org.example.model.Static.StaticList;

public class QueueUtil {
    public static Queue copy(Queue originalQueue) {
        Queue copyQueue = new StaticQueue();
        Queue restorationQueue = new StaticQueue();

        while (!originalQueue.isEmpty()) {
            int element = originalQueue.getFirst();
            copyQueue.add(element);
            restorationQueue.add(element);
            originalQueue.remove();
        }

        while (!restorationQueue.isEmpty()) {
            originalQueue.add(restorationQueue.getFirst());
            restorationQueue.remove();
        }

        return copyQueue;
    }

    public static void printQueue(Queue queueToPrint) {
        Queue temporaryQueue = new StaticQueue();
        while (!queueToPrint.isEmpty()) {
            int element = queueToPrint.getFirst();
            System.out.print(element + " ");
            temporaryQueue.add(element);
            queueToPrint.remove();
        }
        while (!temporaryQueue.isEmpty()) {
            queueToPrint.add(temporaryQueue.getFirst());
            temporaryQueue.remove();
        }
        System.out.println();
    }

    public static void bubbleSort(Queue queue) {
        // Extraemos los elementos de la cola en una instancia de nuestro TDA List.
        List list = new StaticList();
        while (!queue.isEmpty()) {
            list.add(queue.getFirst());
            queue.remove();
        }

        int n = list.size();
        // Aplicamos el algoritmo de burbuja.
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        // Reconstruimos la cola con los elementos ordenados.
        for (int i = 0; i < n; i++) {
            queue.add(list.get(i));
        }
    }
}