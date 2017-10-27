package com.javarush.task.task28.task2805;

/**
 * Created by Lagster on 15.07.2017.
 */
public class MyThread extends Thread {
    static int PRIORITY = 0;

    public MyThread() {
        myPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        myPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        myPriority();
    }

    public MyThread(String name) {
        super(name);
        myPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        myPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        myPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        myPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        myPriority();
    }

    private void myPriority() {
        if (getThreadGroup().activeCount() == 0) {
            PRIORITY = PRIORITY  % 10 + 1;
            setPriority(PRIORITY);
        }
        else {
            int MAX_PRIORITY = getThreadGroup().getMaxPriority();
            if (PRIORITY  % 10 + 1 < MAX_PRIORITY) {
                PRIORITY = PRIORITY % 10 + 1;
                setPriority(PRIORITY);
            }
            else {
                setPriority(MAX_PRIORITY);
                PRIORITY = 0;
            }
        }
    }
}
