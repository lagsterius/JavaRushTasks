package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1, path2;
        path1 = reader.readLine();
        path2 = reader.readLine();
        reader.close();

        BufferedReader file1 = new BufferedReader(new FileReader(path1));
        BufferedReader file2 = new BufferedReader(new FileReader(path2));

        List<String> file1Str = new ArrayList<>();
        List<String> file2Str = new ArrayList<>();

        while (file1.ready())
            file1Str.add(file1.readLine());
        file1.close();
        while (file2.ready())
            file2Str.add(file2.readLine());
        file2.close();

        while (file1Str.size() > 0 || file2Str.size() > 0) {
            if (file1Str.size() == 0) {
                lines.add(new LineItem(Type.ADDED, file2Str.get(0)));
                file2Str.remove(0);
            } else if (file2Str.size() == 0) {
                lines.add(new LineItem(Type.REMOVED, file1Str.get(0)));
                file1Str.remove(0);
            } else if (file1Str.size() == 1) {
                if (file1Str.get(0).equals(file2Str.get(0))) {
                    lines.add(new LineItem(Type.SAME, file1Str.get(0)));
                    file1Str.remove(0);
                    file2Str.remove(0);
                } else {
                    lines.add(new LineItem(Type.ADDED, file2Str.get(0)));
                    file2Str.remove(0);
                }
            } else if (file2Str.size() == 1) {
                if (file1Str.get(0).equals(file2Str.get(0))) {
                    lines.add(new LineItem(Type.SAME, file1Str.get(0)));
                    file1Str.remove(0);
                    file2Str.remove(0);
                } else {
                    lines.add(new LineItem(Type.REMOVED, file1Str.get(0)));
                    file1Str.remove(0);
                }
            } else {
                if (file1Str.get(0).equals(file2Str.get(0))) {
                    lines.add(new LineItem(Type.SAME, file1Str.get(0)));
                    file1Str.remove(0);
                    file2Str.remove(0);
                } else if (file1Str.get(0).equals(file2Str.get(1))) {
                    lines.add(new LineItem(Type.ADDED, file2Str.get(0)));
                    file2Str.remove(0);
                } else {
                    lines.add(new LineItem(Type.REMOVED, file1Str.get(0)));
                    file1Str.remove(0);
                }
            }
        }

        for (LineItem l : lines)
            System.out.println(l.type.toString() + " " + l.line);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
