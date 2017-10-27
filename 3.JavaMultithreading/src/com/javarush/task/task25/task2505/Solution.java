package com.javarush.task.task25.task2505;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
Без дураков
*/
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;
        private Logger logger = Logger.getLogger("My Thread");
        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(false);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String message = String.format("%s, %s, %s", secretKey, t.getName(), e.getMessage());
                logger.log(Level.SEVERE, e.getMessage());
                try {
                    t.sleep(500);
                } catch (InterruptedException e1) {
                    //e1.printStackTrace();
                }
                System.out.println(message);
            }
        }
    }

}

