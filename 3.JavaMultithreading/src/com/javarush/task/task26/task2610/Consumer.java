package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Lagster on 11.07.2017.
 */
public class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        Object o = queue.poll();
        while (o != null) {
            System.out.println(o);
            o = queue.poll();
        }
    }
}
