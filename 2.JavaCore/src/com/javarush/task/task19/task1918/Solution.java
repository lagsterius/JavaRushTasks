package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader file = new FileReader(reader.readLine());
        reader.close();
        StringBuilder sb = new StringBuilder();
        while (file.ready())
            sb.append(String.valueOf((char)file.read()));
        file.close();

        List<Integer> o = new ArrayList<>();
        List<Integer> c = new ArrayList<>();

        int ind = 0;
        while (true) {
            ind = sb.indexOf("<" + args[0], ind);
            if (ind == -1)
                break;
            o.add(ind);
            ind++;
        }

        ind = 0;
        while (true) {
            ind = sb.indexOf("/" + args[0], ind);
            if (ind == -1)
                break;
            c.add(ind);
            ind++;
        }

        while (o.size() > 1) {
            for (int i = 1; i < o.size(); i++)
                if (o.get(i) > c.get(0)) {
                    System.out.println(sb.substring(o.get(0), c.get(i - 1) + 2 + args[0].length()));
                    o.remove(0);
                    c.remove(i - 1);
                }
        }
        System.out.println(sb.substring(o.get(0), c.get(0) + 2 + args[0].length()));
    }
}
