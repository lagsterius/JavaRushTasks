package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader file = new FileReader(reader.readLine());
        reader.close();
        StringBuilder sb = new StringBuilder();
        while (file.ready())
            sb.append(String.valueOf((char)file.read()));

        String[] spl = sb.toString().split(" ");


        file.close();
        StringBuilder result = getLine(spl);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        List<String> list = new ArrayList<>();

        for (String s : words)
            list.add(s);

        String fl = "";
        int len = 0;
        StringBuilder res = new StringBuilder();
        int startLen = -1, finishLen = 0;
        while (startLen != finishLen) {
            startLen = list.size();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).substring(0, 1).toLowerCase().equals(fl) || fl.equals("")) {
                    fl = list.get(i).substring(list.get(i).length() - 1).toLowerCase();
                    res.append(list.get(i));
                    res.append(" ");
                    list.remove(i);
                } else if (list.get(i).substring(list.get(i).length() - 1).toLowerCase().equals(res.toString().substring(0, 1).toLowerCase())) {
                    String tmpRes = res.toString();
                    res = new StringBuilder(list.get(i) + " " + tmpRes);
                    list.remove(i);
                }
            }
            finishLen = list.size();
        }
        if (res.length() > 1)
            res.delete(res.length() - 1, res.length());


        return res;
    }
}
