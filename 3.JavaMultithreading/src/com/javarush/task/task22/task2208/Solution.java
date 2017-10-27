package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();

        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();

        if (params == null || params.isEmpty())
            return sb.toString();

        for (Map.Entry<String, String> entry : params.entrySet())
            if (entry.getValue() != null)
                sb.append(String.format("%s = '%s' and ", entry.getKey(), entry.getValue()));

        if (sb.length() > 5)
            sb.delete(sb.length() - 5, sb.length());

        return sb.toString();
    }
}
