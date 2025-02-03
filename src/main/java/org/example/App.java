package org.example;

import org.example.model.Queue;
import org.example.model.StaticQueue;
import org.example.model.List;
import org.example.model.StaticList;
import org.example.model.Stack;
import org.example.model.StaticStack;
import org.example.util.QueueUtil;
import org.example.util.StackListUtil;
import org.example.util.StackUtil;

public class App {

    public static void main(String[] args) {

        // --- Demostración de conversión entre Lista y Pila ---

        // Crear e inicializar una lista de ejemplo.
        List sampleList = new StaticList();
        sampleList.add(10);
        sampleList.add(20);
        sampleList.add(30);

        // Convertir la lista a una pila.
        Stack stackFromList = StackListUtil.mapListToStack(sampleList);
        System.out.println("Pila obtenida a partir de la lista:");
        StackUtil.print(stackFromList);
        System.out.println();

        // Crear y llenar una pila de ejemplo.
        Stack sampleStack = new StaticStack();
        sampleStack.add(10);
        sampleStack.add(20);
        sampleStack.add(30);

        // Convertir la pila a una lista.
        List listFromStack = StackListUtil.mapStackToList(sampleStack);
        System.out.println("Lista obtenida a partir de la pila:");
        for (int index = 0; index < listFromStack.size(); index++) {
            System.out.print(listFromStack.get(index) + " ");
        }
        System.out.println();

        // --- Demostración de Queue y ordenamiento (Bubble Sort) ---

        // Crear e inicializar la cola con elementos desordenados.
        Queue unsortedQueue = new StaticQueue();
        unsortedQueue.add(5);
        unsortedQueue.add(2);
        unsortedQueue.add(9);
        unsortedQueue.add(1);

        System.out.println("Cola original:");
        // Imprimir la cola sin destruirla.
        QueueUtil.printQueue(unsortedQueue);

        // Ordenar la misma cola.
        QueueUtil.bubbleSort(unsortedQueue);

        System.out.println("Cola ordenada con Bubble Sort:");
        QueueUtil.printQueue(unsortedQueue);
    }
}