package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize = 0;
    private int maxSize = Integer.MAX_VALUE;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (!Files.isRegularFile(file))
            return FileVisitResult.CONTINUE;
        if (partOfName != null && !file.getFileName().toString().contains(partOfName))
            return FileVisitResult.CONTINUE;
        if (partOfContent != null && !new String(Files.readAllBytes(file)).contains(partOfContent))
            return FileVisitResult.CONTINUE;
        if (minSize != 0 && attrs.size() < minSize)
            return FileVisitResult.CONTINUE;
        if (maxSize != Integer.MAX_VALUE && attrs.size() > maxSize)
            return FileVisitResult.CONTINUE;

        foundFiles.add(file);

        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
