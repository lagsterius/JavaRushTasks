package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        int oldNumber = number;

        int[] pows = {1, 3, 9, 27, 81, 243, 729, 2187};

        int[] res = new int[8];

        for (int i = 0; i < 8; i++) {
            res[i] = number % 3;
            number = number / 3 + (res[i] == 2 ? 1 : 0);
        }

        String strRes = String.format("%d =", oldNumber);
        for (int i = 0; i < 8; i++) {
            if (res[i] != 0)
                strRes += (res[i] == 1 ? " + " : " - ")+ pows[i];
        }

        System.out.println(strRes);

    }
}