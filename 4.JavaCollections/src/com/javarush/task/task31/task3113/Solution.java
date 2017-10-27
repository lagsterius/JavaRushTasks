package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

/*
Что внутри папки?
*/
public class Solution {
    public static int countFiles = 0;
    public static int countFolders = 0;
    public static long totalSize = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String path = reader.readLine();

        Path curPath = Paths.get(path);


        if (Files.isDirectory(curPath)) {
            Files.walkFileTree(curPath, new SimpleFileVisitor<Path>() {

                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
                {
                    countFolders++;
                    return FileVisitResult.CONTINUE;
                }

                public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
                    countFiles++;
                    totalSize+= fileAttributes.size();
                    return FileVisitResult.CONTINUE;
                }
            });
            System.out.printf("Всего папок - %d\n", countFolders - 1);
            System.out.printf("Всего файлов - %d\n", countFiles);
            System.out.printf("Общий размер - %d\n", totalSize);
        } else {
            System.out.printf("%s - не папка", path);
        }
    }
}
