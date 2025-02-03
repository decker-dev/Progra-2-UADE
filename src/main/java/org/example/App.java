package org.example;

import org.example.model.Queue;
import org.example.model.StaticQueue;
import org.example.model.List;
import org.example.model.StaticList;
import org.example.model.Stack;
import org.example.util.QueueUtil;
import org.example.util.StackListUtil;

public class App {

    public static void main(String[] args) {
        // --- Demostración de Queue y ordenamiento (Bubble Sort) ---
        Queue queue = new StaticQueue();
        // Insertamos algunos elementos desordenados.
        queue.add(5);
        queue.add(2);
        queue.add(9);
        queue.add(1);

        System.out.println("Cola original:");
        Queue copyQueue = QueueUtil.copy(queue); // para imprimir sin modificar la cola original
        while (!copyQueue.isEmpty()) {
            System.out.print(copyQueue.getFirst() + " ");
            copyQueue.remove();
        }
        System.out.println();

        // Ordenamos la cola.
        // Para este ejemplo, volvemos a insertar los mismos elementos.
        queue.add(5);
        queue.add(2);
        queue.add(9);
        queue.add(1);
        QueueUtil.bubbleSort(queue);

        System.out.println("Cola ordenada con Bubble Sort:");
        while (!queue.isEmpty()) {
            System.out.print(queue.getFirst() + " ");
            queue.remove();
        }
        System.out.println("\n");

        // --- Demostración de conversión entre Lista y Pila ---
        // Creamos una lista y agregamos elementos.
        List list = new StaticList();
        list.add(10);
        list.add(20);
        list.add(30);

        // Convertimos la lista a una pila.
        Stack stack = StackListUtil.mapListToStack(list);
        System.out.println("Pila obtenida a partir de la lista:");
        while (!stack.isEmpty()) {
            System.out.print(stack.getTop() + " ");
            stack.remove();
        }
        System.out.println();

        // Volvemos a llenar la pila.
        stack.add(100);
        stack.add(200);
        stack.add(300);

        // Convertimos la pila a una lista.
        List listFromStack = StackListUtil.mapStackToList(stack);
        System.out.println("Lista obtenida a partir de la pila:");
        for (int i = 0; i < listFromStack.size(); i++) {
            System.out.print(listFromStack.get(i) + " ");
        }
        System.out.println();
    }
}