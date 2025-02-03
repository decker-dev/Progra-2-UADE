package org.example.util;

import org.example.model.Queue;
import org.example.model.StaticQueue;
import org.example.model.List;
import org.example.model.StaticList;

public class QueueUtil {
    public static Queue copy(Queue queue) {
        Queue aux = new StaticQueue();
        Queue aux2 = new StaticQueue();

        while(!queue.isEmpty()) {
            aux.add(queue.getFirst());
            aux2.add(queue.getFirst());
            queue.remove();
        }

        while(!aux2.isEmpty()) {
            queue.add(aux2.getFirst());
            aux2.remove();
        }

        return aux;
    }

    public static void bubbleSort(Queue queue) {
        // Extraemos los elementos de la cola en nuestro TDA List.
        List list = new StaticList();
        while (!queue.isEmpty()) {
            list.add(queue.getFirst());
            queue.remove();
        }

        int n = list.size();
        // Aplicamos el algoritmo de burbuja sobre la lista.
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    // Intercambiamos los elementos usando el método set.
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