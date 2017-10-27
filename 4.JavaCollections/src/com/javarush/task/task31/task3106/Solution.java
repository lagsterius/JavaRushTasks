package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        String resultFileName = args[0];
        String[] fileNamePart = Arrays.copyOfRange(args, 1, args.length);
        Arrays.sort(fileNamePart);

        Vector<InputStream> vector = new Vector<>();
        for (String s : fileNamePart)
            try {
                vector.add(new FileInputStream(s));
            } catch (FileNotFoundException ignored) {}

        try (ZipInputStream zis = new ZipInputStream(new SequenceInputStream(vector.elements()));
             FileOutputStream fos = new FileOutputStream(resultFileName)) {

            zis.getNextEntry();
            byte[] buffer = new byte[1024];
            int l;
            while ((l = zis.read(buffer)) > 0)
                fos.write(buffer, 0, l);
        } catch (IOException ignored) {}
    }
}
