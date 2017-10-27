package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result;
        List list = ArmstrongNumbersMultiSetLongOpt.generate((int) (Math.log10(N)));

        int ls = list.size();
        result = new long[ls];
        for (int k = 0; k < ls; k++)
            result[k] = (Long) list.get(k);
        return result;
    }

    public static void main(String[] args) {
        long memoryStart = Runtime.getRuntime().freeMemory();
        long start = new Date().getTime();
        long[] array = getNumbers(Long.MAX_VALUE);
        long finish = new Date().getTime() - start;
        long totalMem = Runtime.getRuntime().totalMemory();

        System.out.println("Time : " + finish / 1000. + " Sec");
        System.out.println(String.format("Mem : %.2f  Mb", 1.0 * (totalMem - memoryStart )/ (1024 * 1024)));
        System.out.println(Arrays.toString(array));
    }
}
