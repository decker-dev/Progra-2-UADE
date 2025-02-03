package org.example.util;

import org.example.model.List;
import org.example.model.StaticList;
import org.example.model.Stack;
import org.example.model.StaticStack;

public class StackListUtil {

    /**
     * Convierte una lista a una pila.
     * Precondición: list no es null.
     * Postcondición: Se retorna una pila con los mismos elementos que la lista.
     * El primer elemento de la lista quedará en el fondo de la pila.
     *
     * @param list La lista a convertir.
     * @return Una pila con los elementos de la lista.
     */
    public static Stack mapListToStack(List list) {
        Stack stack = new StaticStack();
        for (int i = 0; i < list.size(); i++) {
            stack.add(list.get(i));
        }
        return stack;
    }

    /**
     * Convierte una pila a una lista.
     * Precondición: stack no es null.
     * Postcondición: Se retorna una lista con los mismos elementos que la pila,
     * manteniendo el orden original, y la pila se restaura.
     *
     * @param stack La pila a convertir.
     * @return Una lista con los elementos de la pila.
     */
    public static List mapStackToList(Stack stack) {
        List list = new StaticList();
        Stack aux = new StaticStack();

        // Transferimos los elementos de la pila a una auxiliar.
        while (!stack.isEmpty()) {
            int x = stack.getTop();
            stack.remove();
            aux.add(x);
        }

        // Restauramos la pila y llenamos la lista con el mismo orden.
        while (!aux.isEmpty()) {
            int x = aux.getTop();
            aux.remove();
            list.add(x);
            stack.add(x);
        }

        return list;
    }
}