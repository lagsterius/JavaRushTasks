package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/*
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();

        try {
            Path file = Paths.get(fileName);
            if (Files.exists(file)) {
                if (fileName.substring(fileName.lastIndexOf('.') + 1).equals("xml"))
                    properties.loadFromXML(new FileInputStream(file.toAbsolutePath().toString()));
                else
                    properties.load(new FileInputStream(fileName));
            }
        } catch (Exception e) {
            return new Properties();
        }

        return properties;
    }
}
