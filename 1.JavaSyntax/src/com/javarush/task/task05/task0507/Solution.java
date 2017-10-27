package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int curInt = 0, count = 0;
        double sum = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            curInt = Integer.parseInt(reader.readLine());
            while (curInt != -1) {
                sum += (double) curInt;
                count++;
                curInt = Integer.parseInt(reader.readLine());
            }
            System.out.println(sum / count);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}

