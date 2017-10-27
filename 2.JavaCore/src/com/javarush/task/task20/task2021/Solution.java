package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Запрет сериализации
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        public void readObject(ObjectInputStream inputStream) throws NotSerializableException {
            throw new NotSerializableException();
        }

        public void writeObject(ObjectOutputStream outputStream) throws NotSerializableException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("c:\\users\\lagster\\desktop\\file1.txt");
        FileInputStream fis = new FileInputStream("c:\\users\\lagster\\desktop\\file2.txt");

        ObjectOutputStream oos = new ObjectOutputStream(fos);
        ObjectInputStream ois = new ObjectInputStream(fis);


    }
}
