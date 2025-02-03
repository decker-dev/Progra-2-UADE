package org.example;

import org.example.model.Queue;
import org.example.model.StaticQueue;
import org.example.model.List;
import org.example.model.StaticList;
import org.example.model.Stack;
import org.example.model.StaticStack;
import org.example.util.QueueUtil;
import org.example.util.StackListUtil;

public class App {

    public static void main(String[] args) {
        Queue originalQueue = new StaticQueue();
        originalQueue.add(5);
        originalQueue.add(2);
        originalQueue.add(9);
        originalQueue.add(1);

        System.out.println("Cola original:");
        // Usar una copia para imprimir sin modificar la cola original.
        Queue printedQueue = QueueUtil.copy(originalQueue);
        while (!printedQueue.isEmpty()) {
            System.out.print(printedQueue.getFirst() + " ");
            printedQueue.remove();
        }
        System.out.println();

        // Crear una nueva cola para ordenar (para evitar duplicados).
        Queue queueToSort = new StaticQueue();
        queueToSort.add(5);
        queueToSort.add(2);
        queueToSort.add(9);
        queueToSort.add(1);

        QueueUtil.bubbleSort(queueToSort);

        System.out.println("Cola ordenada con Bubble Sort:");
        while (!queueToSort.isEmpty()) {
            System.out.print(queueToSort.getFirst() + " ");
            queueToSort.remove();
        }
        System.out.println("\n");

        // --- Demostración de conversión entre Lista y Pila ---

        // Crear e inicializar una lista de ejemplo.
        List sampleList = new StaticList();
        sampleList.add(10);
        sampleList.add(20);
        sampleList.add(30);

        // Convertir la lista a una pila.
        Stack stackFromList = StackListUtil.mapListToStack(sampleList);
        System.out.println("Pila obtenida a partir de la lista:");
        while (!stackFromList.isEmpty()) {
            System.out.print(stackFromList.getTop() + " ");
            stackFromList.remove();
        }
        System.out.println();

        // Crear y llenar una pila de ejemplo.
        Stack sampleStack = new StaticStack();
        sampleStack.add(100);
        sampleStack.add(200);
        sampleStack.add(300);

        // Convertir la pila a una lista.
        List listFromStack = StackListUtil.mapStackToList(sampleStack);
        System.out.println("Lista obtenida a partir de la pila:");
        for (int index = 0; index < listFromStack.size(); index++) {
            System.out.print(listFromStack.get(index) + " ");
        }
        System.out.println();
    }
}