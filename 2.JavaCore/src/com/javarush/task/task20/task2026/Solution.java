package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int finishX;
        int finishY;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    count++;
                    finishX = i;
                    finishY = j;
                    for (int k = i; k < a.length; k++)
                        if (a[k][j] == 1)
                            finishX++;
                    for (int k = j; k < a[0].length; k++)
                        if (a[i][k] == 1)
                            finishY++;

                    for (int k = i; k < finishX; k++)
                        for (int l = j; l < finishY; l++)
                            a[k][l] = 0;
                }
            }
        }
        return count;
    }
}
