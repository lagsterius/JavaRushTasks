package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String curName = "";
        Boolean isExit = false;
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));

        while (!isExit) {
            curName = reader.readLine();

            try {
                FileReader file = new FileReader(curName);
                if (!file.ready()) {
                    throw new FileNotFoundException();
                }
                file.close();
            } catch (FileNotFoundException e) {
                isExit = true;
            }

        }

        reader.close();
        System.out.println(curName);
    }
}
