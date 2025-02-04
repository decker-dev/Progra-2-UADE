package org.example.util;

import org.example.model.Static.PriorityQueue;
import org.example.model.Static.StaticPriorityQueue;


public class PriorityQueueUtil {
    public static PriorityQueue copyPriorityQueue(PriorityQueue queue) {
        PriorityQueue aux = new StaticPriorityQueue();
        PriorityQueue aux2 = new StaticPriorityQueue();

        while (!queue.isEmpty()) {
            int value = queue.getFist();
            int priority = queue.getPriority();

            aux.add(value, priority);
            aux2.add(value, priority);
            queue.remove();
        }
        return queue;
    }
}
