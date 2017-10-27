package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<String> getFileTree(String root) {
        List<String> list = new ArrayList<>();
        Path path = Paths.get(root);

        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
                    list.add(path.toString());
                    return FileVisitResult.CONTINUE;
                }

                public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
    public static void main(String[] args) {
        getFileTree("C:\\users\\lagster\\desktop").forEach(System.out::println);
    }

}
