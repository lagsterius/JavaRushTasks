package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * Created by Lagster on 19.07.2017.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            if (!currentThread().isInterrupted()) {
                System.out.format("Элемент 'ShareItem-%s' добавлен\n", i);
                queue.offer(new ShareItem("ShereItem-" + i, i));
                try {
                    sleep(100);
                } catch (InterruptedException e) {}
                if (queue.hasWaitingConsumer())
                    System.out.format("Consumer в ожидании!\n");
            } else break;
        }
    }
}
