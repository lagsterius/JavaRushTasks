package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Str, file2Str, strDigit[];

        file1Str = reader.readLine();
        file2Str = reader.readLine();
        reader.close();

        BufferedReader file1 = new BufferedReader((new FileReader(file1Str)));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(file2Str));

        List<String> digits = new ArrayList<>();
        while (file1.ready())
        {
            strDigit = file1.readLine().split(" ");
            for (String s : strDigit)
                digits.add(String.valueOf(Math.round(Double.parseDouble(s))) + " ");
        }
        file1.close();

       for (String s : digits)
            file2.write(s);
        file2.close();
    }
}
