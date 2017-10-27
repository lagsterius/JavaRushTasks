package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{
        String path, curStr;
        List<String[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        path = reader.readLine();
        reader.close();

        BufferedReader file = new BufferedReader(new FileReader(path));

        while (file.ready()) {
            curStr = file.readLine();
            list.add(curStr.split(" "));
        }
        file.close();

        for (String[] s : list)
            if (s[0].equals(args[0]))
                System.out.println(s[0] + " " + s[1] + " " + s[2] + " " + s[3]);
    }
}
