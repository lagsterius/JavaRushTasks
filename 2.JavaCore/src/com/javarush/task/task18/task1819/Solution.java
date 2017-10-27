package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1Str, file2Str;

        file1Str = reader.readLine();
        file2Str = reader.readLine();


        FileInputStream file1 = new FileInputStream(file1Str);
        byte[] bufFile1 = new byte[file1.available()];
        file1.read(bufFile1, 0, file1.available());
        file1.close();

        BufferedWriter file1writer = new BufferedWriter(new FileWriter(file1Str));
        BufferedReader file2 = new BufferedReader(new FileReader(file2Str));

        file1writer.write("");

        while (file2.ready())
            file1writer.write(file2.readLine());

        file2.close();

        for (int i = 0; i < bufFile1.length; i++)
            file1writer.write((char)bufFile1[i]);

        file1writer.close();
    }
}
