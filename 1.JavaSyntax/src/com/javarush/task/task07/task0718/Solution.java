package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        int curLen, lastLen = 0, wrongIndex = -1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
            curLen = list.get(list.size() - 1).length();
            if (curLen < lastLen && wrongIndex == -1)
                wrongIndex = i;
            lastLen = curLen;
        }

        if (wrongIndex != -1)
            System.out.println(wrongIndex);
    }
}

