package com.javarush.task.task19.task1923;

/*
Слова с цифрами
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileReader file1 = new FileReader(args[0]);
        StringBuilder strings = new StringBuilder();
        while (file1.ready())
            strings.append(String.valueOf((char)file1.read()));
        file1.close();

        String[] words = strings.toString().split(" |\r\n|\n");
        List<String> list = new ArrayList<>();

        for (String s : words)
            if (s.replaceAll("[^0-9]", "").length() > 0)
                list.add(s);

        FileWriter file2 = new FileWriter(args[1]);
        for (String s : list) {
            file2.write(s);
            file2.write(" ");
        }
        file2.close();
    }
}
