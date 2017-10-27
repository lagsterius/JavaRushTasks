package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        FileInputStream file1 = new FileInputStream(args[0]);
        FileOutputStream file2 = new FileOutputStream(args[1]);

        byte[] buffer = new byte[file1.available()];
        file1.read(buffer, 0, file1.available());
        file1.close();

        file2.write(new String(buffer, "UTF-8").getBytes("Windows-1251"));
        file2.close();
        }
    }
