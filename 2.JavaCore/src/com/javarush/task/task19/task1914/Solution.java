package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        testString.printSomething();
        String[] spl = outputStream.toString().split(" ");
        int a = Integer.parseInt(spl[0]);
        int b = Integer.parseInt(spl[2]);
        int c = spl[1].equals("*") ? a * b : spl[1].equals("+") ? a + b : a - b;
        String res = outputStream.toString();
        res = res + String.valueOf(c);
        System.setOut(oldOut);
        System.out.println(res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

