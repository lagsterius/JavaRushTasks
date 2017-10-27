package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.FileHandler;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader file = new FileReader(reader.readLine());
        reader.close();

        StringBuilder sb = new StringBuilder();

        while (file.ready())
            sb.append(String.valueOf((char) file.read()));

        file.close();

        String[] words = sb.toString().split(" |\n|\r\n");

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i] != "" && words[i].equals(new StringBuilder(words[j]).reverse().toString())) {
                    result.add(new Pair());
                    result.get(result.size() - 1).first = words[i];
                    result.get(result.size() - 1).second = words[j];

                    if (result.size() > 1) {
                        for (int k = 0; k < result.size() - 1; k++) {
                            if (result.get(result.size() - 1).equals(result.get(k)))
                                result.remove(result.size() - 1);
                        }
                    }
                }
            }
        }
        result.forEach(System.out::println);
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
