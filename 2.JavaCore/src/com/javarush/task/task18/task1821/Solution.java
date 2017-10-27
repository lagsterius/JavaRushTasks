package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileReader;

public class Solution {
    public static void main(String[] arg) throws Exception{
        String[] args = new String[1];
        args[0] = "c:\\users\\lagster\\desktop\\file1.txt";
        int[] fr = new int[256];
        int curChar;
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()) {
            curChar = reader.read();
            fr[curChar]++;
        }
        reader.close();

        for (int i = 0; i < 256; i++)
            if (fr[i] != 0)
                System.out.println(Character.toString((char)i) + " " + fr[i]);

    }
}
