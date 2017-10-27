package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{

        String curStr, path;
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, byte[]> map = new TreeMap<>();
        curStr = reader.readLine();
        path = curStr.split("\\.")[0] + "." + curStr.split("\\.")[1];
        while (!curStr.equals("end")) {
            FileInputStream file = new FileInputStream(curStr);
            byte[] buffer = new byte[file.available()];
            file.read(buffer, 0, file.available());
            file.close();
            map.put(Integer.parseInt(curStr.split(".part")[1]), buffer);
            curStr = reader.readLine();
        }
        reader.close();

        File file = new File(path);

        if (!file.exists())
            file.createNewFile();

        FileOutputStream fw = new FileOutputStream(path);
        for (Map.Entry<Integer, byte[]> entry : map.entrySet())
            fw.write(entry.getValue());
        fw.close();
    }
}
