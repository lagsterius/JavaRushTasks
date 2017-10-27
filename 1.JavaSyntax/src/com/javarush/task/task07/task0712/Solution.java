package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int min = 0, max = 0, minL = Integer.MAX_VALUE, maxL = 0;

        ArrayList<String> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++)
            list.add(reader.readLine());

        for (int i = 0; i < 10; i++) {
            if (list.get(i).length() < minL) {
                min = i;
                minL = list.get(i).length();
            }
        }

        for (int i = 0; i < 10; i++) {
            if (list.get(i).length() > maxL) {
                max = i;
                maxL = list.get(i).length();
            }
        }

        System.out.println(list.get(min < max ? min : max));
    }
}
