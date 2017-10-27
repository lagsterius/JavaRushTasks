package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> res = new ArrayList<>();
        for (String s : words) {
            List<Integer> first = new ArrayList<>();
            List<Integer> last = new ArrayList<>();
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[0].length; j++) {
                    if (crossword[i][j] == (int) s.substring(0, 1).toCharArray()[0]) {
                        first.add(j);
                        first.add(i);
                    }
                    if (crossword[i][j] == (int) s.substring(s.length() - 1, s.length()).toCharArray()[0]) {
                        last.add(j);
                        last.add(i);
                    }
                }
            }
            System.out.println();

            int fi = -1;
            int fj = -1;
            int li = -1;
            int lj = -1;

            for (int i = 0; i < first.size(); i+= 2) {
                for (int j = 0; j < last.size(); j+= 2) {
                    if ((first.get(i) + s.length() - 1) == last.get(j) && first.get(i + 1) == last.get(j + 1) ||
                            (first.get(i) - s.length() + 1) == last.get(j) && first.get(i + 1) == last.get(j + 1) ||
                                first.get(i) == last.get(j) && (first.get(i + 1) + s.length() - 1) == last.get(j + 1) ||
                                    first.get(i) == last.get(j) && (first.get(i + 1) - s.length() + 1) == last.get(j + 1) ||
                                        (first.get(i) + s.length() - 1) == last.get(j) && (first.get(i + 1) + s.length() - 1) == last.get(j + 1) ||
                                            (first.get(i) + s.length() - 1) == last.get(j) && (first.get(i + 1) - s.length() + 1) == last.get(j + 1) ||
                                                (first.get(i) - s.length() + 1) == last.get(j) && (first.get(i + 1) + s.length() - 1) == last.get(j + 1) ||
                                                    (first.get(i) - s.length() + 1) == last.get(j) && (first.get(i + 1) - s.length() + 1) == last.get(j + 1)) {
                        fi = first.get(i);
                        fj = first.get(i + 1);
                        li = last.get(j);
                        lj = last.get(j + 1);
                    }
                }
            }
            res.add(new Word(s));
            res.get(res.size() - 1).setStartPoint(fi, fj);
            res.get(res.size() - 1).setEndPoint(li, lj);
            System.out.println(res.get(res.size() - 1).toString());
        }
        return res;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
