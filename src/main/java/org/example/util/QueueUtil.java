package org.example.util;

import org.example.model.Queue;
import org.example.model.StaticQueue;
import org.example.model.List;
import org.example.model.StaticList;

public class QueueUtil {

    /**
     * Crea una copia de la cola sin modificar la original.
     * Precondición: La cola original no es null.
     * Postcondición: Se retorna una nueva cola que contiene los mismos elementos que la original.
     *
     * @param originalQueue La cola a copiar.
     * @return Una copia de la cola original.
     */
    public static Queue copy(Queue originalQueue) {
        Queue copyQueue = new StaticQueue();
        Queue restorationQueue = new StaticQueue();

        while (!originalQueue.isEmpty()) {
            int firstElement = originalQueue.getFirst();
            copyQueue.add(firstElement);
            restorationQueue.add(firstElement);
            originalQueue.remove();
        }

        while (!restorationQueue.isEmpty()) {
            originalQueue.add(restorationQueue.getFirst());
            restorationQueue.remove();
        }

        return copyQueue;
    }

    /**
     * Ordena la cola utilizando el algoritmo de burbuja y nuestro TDA List.
     * Precondición: La cola a ordenar no es null.
     * Postcondición: La cola queda ordenada de forma ascendente.
     *
     * @param queueToSort La cola que se desea ordenar.
     */
    public static void bubbleSort(Queue queueToSort) {
        // Extraer todos los elementos de la cola a una lista temporal.
        List temporaryList = new StaticList();
        while (!queueToSort.isEmpty()) {
            temporaryList.add(queueToSort.getFirst());
            queueToSort.remove();
        }

        int listSize = temporaryList.size();
        // Aplicar el algoritmo de burbuja.
        for (int outerIndex = 0; outerIndex < listSize - 1; outerIndex++) {
            for (int innerIndex = 0; innerIndex < listSize - 1 - outerIndex; innerIndex++) {
                if (temporaryList.get(innerIndex) > temporaryList.get(innerIndex + 1)) {
                    int currentElement = temporaryList.get(innerIndex);
                    temporaryList.set(innerIndex, temporaryList.get(innerIndex + 1));
                    temporaryList.set(innerIndex + 1, currentElement);
                }
            }
        }

        // Reconstruir la cola con los elementos ordenados.
        for (int index = 0; index < listSize; index++) {
            queueToSort.add(temporaryList.get(index));
        }
    }
}