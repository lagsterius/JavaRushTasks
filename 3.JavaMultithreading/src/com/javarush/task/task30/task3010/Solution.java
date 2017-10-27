package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            String num = args[0];

            if (!num.matches("\\w+||\\d+")) {
                System.out.println("incorrect");
                return;
            }

            for (int i = 2; i < 37; i++) {
                try {
                    new BigInteger(num, i);
                    System.out.println(i);
                    break;
                } catch (NumberFormatException e) {
                }
            }
        } catch (Exception ignored) {}
    }
}