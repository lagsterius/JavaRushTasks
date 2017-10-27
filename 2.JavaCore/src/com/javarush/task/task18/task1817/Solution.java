package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws Exception{
        int curCh, ws = 0, sum = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

        while (reader.ready()) {
            curCh = reader.read();
            if (curCh == 32)
                ws++;
            sum++;
        }
        reader.close();

        System.out.printf("%.2f", ((double)ws / (double)sum) * 100);
    }
}
