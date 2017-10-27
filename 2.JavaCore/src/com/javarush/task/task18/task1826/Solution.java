package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream input = new FileInputStream(args[1]);
        FileOutputStream output = new FileOutputStream(args[2]);

        byte[] buffer = new byte[input.available()];
        input.read(buffer, 0, input.available());
        input.close();

        for (int i = 0; i < buffer.length; i++)
            buffer[i] = (byte) (args[0].equals("-e") ? (buffer[i] == 127 ? 1 :
                    (buffer[i] + 1)) : (buffer[i] == -128 ? 127 : buffer[i] - 1));

        output.write(buffer);
        output.close();

    }
}
