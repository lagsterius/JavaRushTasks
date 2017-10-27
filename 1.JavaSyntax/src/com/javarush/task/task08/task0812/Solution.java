package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        int maxLen = 1, curLen = 1;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
            if (i > 0 && list.get(i) == list.get(i - 1)) {
                curLen++;
                if (maxLen < curLen)
                    maxLen = curLen;
            }
            else {
                curLen = 1;
            }
        }

        System.out.println(maxLen);
    }
}