package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    private static BufferedReader reader,
        file1,
        file2;

    private static String file1Str,
        file2Str;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            file1Str = reader.readLine();
            file2Str = reader.readLine();
            file1 = new BufferedReader(new FileReader(file1Str));
            file2 = new BufferedReader(new FileReader(file2Str));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            while (file1.ready())
                allLines.add(file1.readLine());
            file1.close();

            while (file2.ready())
                forRemoveLines.add(file2.readLine());
            file2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
