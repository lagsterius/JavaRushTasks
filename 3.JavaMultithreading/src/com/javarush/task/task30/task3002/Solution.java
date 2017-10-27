package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        int radix;

        if (s.substring(0, 2).equals("0x"))
            radix = 16;
        else if (s.substring(0, 2).equals("0b"))
            radix = 2;
        else if (s.substring(0, 1).equals("0"))
            radix = 8;
        else
            radix = 10;
        int x = Integer.parseInt(s.substring(radix == 16 || radix == 2 ? 2 : 0), radix);
        return String.valueOf(x);
    }
}
