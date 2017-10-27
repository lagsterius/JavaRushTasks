package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread t;

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {}
    }

    @Override
    public void start(String threadName) {
        t = new Thread(this);
        t.setName(threadName);
        t.start();
    }

    @Override
    public void stop() {
        t.interrupt();
    }
}
