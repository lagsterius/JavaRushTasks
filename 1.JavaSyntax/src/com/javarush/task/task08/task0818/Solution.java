package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("1", 100);
        hm.put("2", 200);
        hm.put("3", 300);
        hm.put("4", 400);
        hm.put("5", 500);
        hm.put("6", 600);
        hm.put("7", 700);
        hm.put("8", 800);
        hm.put("9", 900);
        hm.put("10", 1000);

        return hm;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() < 500) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
    }
}