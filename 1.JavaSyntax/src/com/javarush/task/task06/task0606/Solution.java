package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] str = reader.readLine().toCharArray();

        for (char c : str)
            if (Integer.parseInt(String.valueOf(c)) % 2 == 0)
                even++;
            else
                odd++;
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
