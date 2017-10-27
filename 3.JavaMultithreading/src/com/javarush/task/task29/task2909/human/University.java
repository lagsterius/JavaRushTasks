package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University extends UniversityPerson {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(String name, int age) {
        super(name, age);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student s : students)
            if (s.getAverageGrade() == averageGrade)
                return s;
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxAverageGrade = 0;

        for (Student s : students)
            if (s.getAverageGrade() > maxAverageGrade)
                maxAverageGrade = s.getAverageGrade();

        for (Student s : students)
            if (s.getAverageGrade() == maxAverageGrade)
                return s;

        return null;
    }

    public Student getStudentWithMinAverageGrade() {
        double minAverageGrade = Double.MAX_VALUE;

        for (Student s : students)
            if (s.getAverageGrade() < minAverageGrade)
                minAverageGrade = s.getAverageGrade();

        for (Student s : students)
            if (s.getAverageGrade() == minAverageGrade)
                return s;

        return null;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}