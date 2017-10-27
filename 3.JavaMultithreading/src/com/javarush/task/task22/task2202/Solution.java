package com.javarush.task.task22.task2202;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null)
            throw new TooShortStringException();
        if (string.length() < 3)
            throw new TooShortStringException();
        String[] spl = string.split(" ");

        if (spl.length < 5)
            throw new TooShortStringException();

        return String.format("%s %s %s %s", spl[1], spl[2], spl[3], spl[4]);
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
