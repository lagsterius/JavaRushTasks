package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solution = new Solution();

        Solution[] solutions = new Solution[2];
        solutions[0] = new Solution();
        solutions[1] = new Solution();

        solutions[0].innerClasses[0] = solution.new InnerClass();
        solutions[0].innerClasses[1] = solution.new InnerClass();
        solutions[1].innerClasses[0] = solution.new InnerClass();
        solutions[1].innerClasses[1] = solution.new InnerClass();

        return solutions;
    }

    public static void main(String[] args) {

    }
}
