package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

/**
 * Created by Lagster on 19.07.2017.
 */
public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            sleep(450);
        } catch (InterruptedException e) {}

        while (!interrupted()) {
            try {
                ShareItem item = queue.take();
                System.out.format("Processing %s\n", item.toString());
            } catch (InterruptedException e) {}
        }
    }
}
