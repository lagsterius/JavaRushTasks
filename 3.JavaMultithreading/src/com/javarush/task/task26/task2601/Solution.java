package com.javarush.task.task26.task2601;

import java.util.HashMap;
import java.util.Map;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here

        int arrSize = array.length;
        int halfSize = arrSize / 2;
        int tmp;
        int med;

        Integer[] medArray = new Integer[arrSize];

        for (int i = 0; i < arrSize - 1; i++) {
            for (int j = i + 1; j < arrSize; j++) {
                if (array[i] > array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }

        med = arrSize % 2 == 0 ? (array[halfSize] + array[halfSize - 1]) / 2 : array[halfSize];

        for (int i = 0; i < arrSize; i++) {
            medArray[i] =  Math.abs(array[i] - med);
        }

        for (int i = 0; i < arrSize - 1; i++) {
            for (int j = i + 1; j < arrSize; j++) {
                if (medArray[i] > medArray[j]) {
                    tmp = medArray[i];
                    medArray[i] = medArray[j];
                    medArray[j] = tmp;
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }

        return array;
    }
}
