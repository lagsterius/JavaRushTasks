package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        getTokens("level22.lesson13.task01", ".");
    }


    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        String[] sa = new String[st.countTokens()];
        int count = 0;
        while (st.hasMoreElements()) {
            sa[count] = st.nextElement().toString();
            count++;
        }

        return sa;
    }
}
