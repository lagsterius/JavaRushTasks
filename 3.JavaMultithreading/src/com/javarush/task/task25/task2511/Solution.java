package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        Thread.UncaughtExceptionHandler myUEH = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String stars = "";
                for (int i = 0; i < t.getName().toString().length(); i++) {
                    stars+= "*";
                }
                String msg = e.getMessage().replaceAll(t.getName(), stars);
                System.out.println(msg);
            }
        };

        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = myUEH;    //init handler here


    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
    }
}