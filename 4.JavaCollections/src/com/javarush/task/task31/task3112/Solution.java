package com.javarush.task.task31.task3112;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://cs541608.userapi.com/c638928/v638928958/5dd3d/irBRZTOfyFE.jpg", Paths.get("c:\\users\\lagster\\desktop"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        Path result = Paths.get(downloadDirectory.toAbsolutePath().toString() + urlString.substring(urlString.lastIndexOf("/")));
        URL url = new URL(urlString);
        Path tempFile = null;
        try {
            tempFile = Files.createTempFile("temp-", ".tmp");
            Files.copy(url.openStream(), tempFile);
            Files.move(tempFile, result);
        } catch (IOException ignored) {}



        // implement this method
        return result;
    }
}
