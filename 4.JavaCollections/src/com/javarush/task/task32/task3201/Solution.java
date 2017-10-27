package com.javarush.task.task32.task3201;

import java.io.RandomAccessFile;

public class Solution {

    public static void main(String... args) {
        String fileName = args[0];
        long number = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            if (number > randomAccessFile.length())
                number = randomAccessFile.length();
            randomAccessFile.seek(number);
            randomAccessFile.write(text.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
