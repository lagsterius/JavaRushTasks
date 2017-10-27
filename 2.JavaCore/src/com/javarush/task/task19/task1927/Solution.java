package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception {
        PrintStream curPS = System.out;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream newPS = new PrintStream(os);
        System.setOut(newPS);
        testString.printSomething();

        String res[] = os.toString().split("\n|\r\n");

        System.setOut(curPS);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
            if (i % 2 == 1)
                System.out.println("JavaRush - курсы Java онлайн");
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
