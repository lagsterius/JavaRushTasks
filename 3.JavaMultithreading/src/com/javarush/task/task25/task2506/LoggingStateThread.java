package com.javarush.task.task25.task2506;

/**
 * Created by Lagster on 02.07.2017.
 */
public class LoggingStateThread extends Thread{
    Thread t;

    LoggingStateThread(Thread t) {
        this.t = t;
    }

    @Override
    public void run() {
        State curState = t.getState();
        State lastState = null;

        while (curState != State.TERMINATED) {
            if (curState != lastState)
                System.out.println(curState);
            lastState = curState;
            curState = t.getState();
        }
        System.out.println(curState);
    }
}