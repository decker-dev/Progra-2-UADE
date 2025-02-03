package org.example.util;

import org.example.model.List;
import org.example.model.StaticList;
import org.example.model.Stack;
import org.example.model.StaticStack;

public class StackListUtil {

    /**
     * Convierte una instancia de List en una instancia de Stack.
     * Precondición: La lista de entrada no es null.
     * Postcondición: Se retorna una pila que contiene los mismos elementos que la lista,
     * preservando el orden (el primer elemento de la lista queda en el fondo de la pila).
     *
     * @param sourceList La lista a convertir.
     * @return Una pila con los elementos de la lista.
     */
    public static Stack mapListToStack(List sourceList) {
        Stack resultingStack = new StaticStack();
        for (int index = 0; index < sourceList.size(); index++) {
            resultingStack.add(sourceList.get(index));
        }
        return resultingStack;
    }

    /**
     * Convierte una instancia de Stack en una instancia de List.
     * Precondición: La pila de entrada no es null.
     * Postcondición: Se retorna una lista que contiene los mismos elementos que la pila,
     * manteniendo el orden original, y se restaura la pila.
     *
     * @param sourceStack La pila a convertir.
     * @return Una lista con los elementos de la pila.
     */
    public static List mapStackToList(Stack sourceStack) {
        List resultingList = new StaticList();
        Stack temporaryStack = new StaticStack();

        // Transferir todos los elementos de la pila original a la pila temporal.
        while (!sourceStack.isEmpty()) {
            int element = sourceStack.getTop();
            sourceStack.remove();
            temporaryStack.add(element);
        }

        // Restaurar la pila original y construir la lista.
        while (!temporaryStack.isEmpty()) {
            int element = temporaryStack.getTop();
            temporaryStack.remove();
            resultingList.add(element);
            sourceStack.add(element);
        }

        return resultingList;
    }
}