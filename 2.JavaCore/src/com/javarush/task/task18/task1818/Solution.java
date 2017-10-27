package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1Str, file2Str, file3Str;

        file1Str = reader.readLine();
        file2Str = reader.readLine();
        file3Str = reader.readLine();


        BufferedWriter file1 = new BufferedWriter(new FileWriter(file1Str));
        BufferedReader file2 = new BufferedReader(new FileReader(file2Str));
        BufferedReader file3 = new BufferedReader(new FileReader(file3Str));

        file1.write("");
        while (file2.ready())
            file1.write(file2.readLine());
        file2.close();

        while (file3.ready())
            file1.write(file3.readLine());
        file3.close();

        file1.close();
    }
}
