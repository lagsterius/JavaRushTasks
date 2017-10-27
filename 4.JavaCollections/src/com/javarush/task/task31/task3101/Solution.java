package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;


public class Solution {
    private static ArrayList<File> set = new ArrayList<>();

    public static void main(String[] args) {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");

        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        try (FileOutputStream fileOutputStream = new FileOutputStream(allFilesContent)) {

            fileList(path);
            set.sort(new FileNameComparator());
            byte[] buffer;
            for (File file : set) {
                FileInputStream fileInputStream = new FileInputStream(file);
                buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                fileOutputStream.write(buffer);
                fileOutputStream.write(new String("\n").getBytes());
                fileOutputStream.flush();
                fileInputStream.close();
            }
            fileOutputStream.close();
        } catch (IOException ignored) {}
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static void fileList(File folder) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory())
                fileList(file);
            else {
                if (file.length() > 50)
                    FileUtils.deleteFile(file);
                else
                    set.add(file);
            }
        }
    }
}

class FileNameComparator implements Comparator<File> {
    public int compare(File first, File second) {
        return first.getName().compareTo(second.getName());
    }
}
