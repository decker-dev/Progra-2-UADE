package org.example.util;

import org.example.model.Queue;
import org.example.model.StaticQueue;

public class QueueUtil {
    public static Queue copyQueue(Queue queue) {
        Queue aux = new StaticQueue();
        Queue aux2 = new StaticQueue();

        while (!queue.isEmpty()) {
            int value = queue.getFist();
            aux.add(value);
            aux2.add(value);
            queue.remove();
        }
        return queue;
    }
}
