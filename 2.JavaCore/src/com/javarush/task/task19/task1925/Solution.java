package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        StringBuilder file1Str = new StringBuilder();
        FileReader file1 = new FileReader(args[0]);
        while (file1.ready())
            file1Str.append(String.valueOf((char)file1.read()));
        file1.close();

        String[] file1Split = file1Str.toString().split(" |\r\n|\n");
        file1Str = new StringBuilder();

        for (String s : file1Split) {
            if (s.length() > 6) {
                file1Str.append(s);
                file1Str.append(",");
            }
        }

        String w = file1Str.substring(0, file1Str.length() - 1).toString();
        FileWriter file2 = new FileWriter(args[1]);
        file2.write(w);
        file2.close();
    }
}
