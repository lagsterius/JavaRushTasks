package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        String result = "";
        if (a == b) {
            result = Integer.toString(a);
        } else if (a < b) {
            for (int i = a; i <= b; i++)
                result += i + " ";
        } else {
            for (int i = a; i >= b; i--)
                result += i + " ";
        }

        return result.trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 100;
        numberB = random.nextInt() % 100;
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}