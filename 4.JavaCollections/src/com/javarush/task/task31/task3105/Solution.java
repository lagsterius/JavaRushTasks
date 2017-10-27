package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String zipPath = args[1];

        File file = new File(fileName);

        Map<String, ByteArrayOutputStream> map = new HashMap<>();

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipPath))) {
            ZipEntry curEntry = zis.getNextEntry();
            ByteArrayOutputStream byteArrayOutputStream;
            int i;
            while (curEntry != null) {
                byteArrayOutputStream = new ByteArrayOutputStream();
                while ((i = zis.read()) != -1)
                    byteArrayOutputStream.write(i);
                map.put(curEntry.getName(), byteArrayOutputStream);
                curEntry = zis.getNextEntry();
            }
        }

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath))) {
            for (Map.Entry<String, ByteArrayOutputStream> e : map.entrySet()) {
                if (e.getKey().substring(e.getKey().lastIndexOf("/") + 1).equals(file.getName())) continue;
                zos.putNextEntry(new ZipEntry(e.getKey().toString()));
                for (char c : e.getValue().toString().toCharArray())
                    zos.write(c);
                zos.closeEntry();
            }

            zos.putNextEntry(new ZipEntry("new/" + file.getName()));
            Files.copy(file.toPath(), zos);
        }
    }
}
