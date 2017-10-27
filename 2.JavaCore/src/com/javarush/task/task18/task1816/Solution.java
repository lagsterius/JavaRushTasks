package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{


        BufferedReader reader = null;
        int curSymb, sum = 0;
        try {
            reader = new BufferedReader(new FileReader(args[0]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (reader.ready())
        {
            curSymb = reader.read();
            if ((curSymb > 64 && curSymb < 91) || (curSymb > 96 && curSymb < 123))
                sum++;
        }

        reader.close();
        System.out.println(sum);
    }
}
