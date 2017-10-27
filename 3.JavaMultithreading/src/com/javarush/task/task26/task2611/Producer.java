package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

/**
 * Created by Lagster on 11.07.2017.
 */
public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> concurrentHashMap) {
        this.map = concurrentHashMap;
    }

    @Override
    public void run() {
        int i = 1;
        String phrase = "Some text for ";
        while (!interrupted()) {
            map.put(String.valueOf(i), phrase + i);
            i++;
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " thread was terminated");
                Thread.currentThread().interrupt();
            }
        }
    }
}
