package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileReader file = new FileReader(fileName);
        StringBuilder strFile = new StringBuilder();
        while (file.ready())
            strFile.append(String.valueOf((char) file.read()));
        file.close();

        String[] words = strFile.toString().split(" |\r\n|\n");

        for (String s : words) {
            try {
                if (map.containsKey(Integer.valueOf(s)))
                    System.out.print(map.get(Integer.valueOf(s)) + " ");
                else
                    throw new Exception();

            } catch (Exception e) {
                System.out.print(s + " ");
            }
        }
    }
}
