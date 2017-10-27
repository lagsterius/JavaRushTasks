package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
        threads.get(4).start();
    }

    static class Thread1 extends Thread{
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run() {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    static class Thread3 extends Thread{
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Thread4 extends Thread implements Message{
        @Override
        public void run() {
            while (!isInterrupted()) {

            }
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }

    static class Thread5 extends Thread{
        @Override
        public void run(){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String curStr = "";
            int sum = 0;
            ArrayList<Integer> list = new ArrayList<>();

            while (!isInterrupted()) {
                try {
                    curStr = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (curStr.equals("N")) {
                    for (Integer i : list)
                        sum+=i;

                    System.out.println(sum);
                }
                else {
                    list.add(Integer.parseInt(curStr));
                }
            }

            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}