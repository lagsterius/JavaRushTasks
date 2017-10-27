package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String curStr;
        curStr = reader.readLine();

        while (!curStr.equals("exit")) {
            new ReadThread(curStr).start();
            curStr = reader.readLine();
        }
        reader.close();

        for (Map.Entry<String, Integer> entry : resultMap.entrySet())
            System.out.println(entry.getKey() + "\t" + entry.getValue());
    }

    public static class ReadThread extends Thread{
        String fileName;
        int max = 0, maxI = 0, curS;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            fileRead();
        }
        // implement file reading here - реализуйте чтение из файла тут
        private void fileRead() {
            BufferedReader file = null;
            Integer[] letters = new Integer[256];

            try {
                file = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            try {
                while (file.ready()) {
                    curS = file.read();
                    try {
                        letters[curS]++;
                    } catch (NullPointerException e) {
                        letters[curS] = 1;
                    }
                }
                file.close();
            } catch (Exception e) {
            }

            for (int i = 0; i < 256; i++)
                if (letters[i] != null)
                    if (letters[i] > max) {
                        max = letters[i];
                        maxI = i;
                    }

            resultMap.put(fileName, maxI);
        }
    }
}
