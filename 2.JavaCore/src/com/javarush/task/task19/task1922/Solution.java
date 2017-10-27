package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        reader.close();

        FileReader file = new FileReader(fileName);
        StringBuilder data = new StringBuilder();
        while (file.ready())
            data.append(String.valueOf((char) file.read()));
        file.close();

        String[] str = data.toString().split("\r\n|\n");

        int count = 0;

        for (String s : str) {
            String[] curSplit = s.split(" ");
            for (String s2 : curSplit)
                if (words.contains(s2))
                    count++;
            if (count == 2)
                System.out.println(s);
            count = 0;
        }
    }
}
