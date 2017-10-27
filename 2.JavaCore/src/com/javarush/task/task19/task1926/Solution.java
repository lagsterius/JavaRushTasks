package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        StringBuilder file1Str = new StringBuilder();
        FileReader file1 = new FileReader(fileName);
        while (file1.ready())
            file1Str.append(String.valueOf((char)file1.read()));
        file1.close();

        String[] file1Split = file1Str.toString().split("\r\n|\n");

        for (String s : file1Split)
            System.out.println(new StringBuilder(s).reverse().toString());
    }
}
