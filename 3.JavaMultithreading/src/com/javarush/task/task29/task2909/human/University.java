package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student studentResult = null;
        for (Student student: students) {
            if (student.getAverageGrade() == averageGrade) studentResult= student;
        }
        return studentResult;
    }

    public Student getStudentWithMaxAverageGrade() {

        double maxAverageGrade = Double.MIN_VALUE;
        Student studentMax = null;

        for (Student student: students) {
            if (student.getAverageGrade() > maxAverageGrade) maxAverageGrade = student.getAverageGrade();
        }

        for (Student student: students) {
            if (student.getAverageGrade() == maxAverageGrade) studentMax = student;
        }
        return studentMax;
    }

    public Student getStudentWithMinAverageGrade() {
        double minAverageGrade = Double.MAX_VALUE;
        Student studentMin = null;

        for (Student student: students) {
            if (student.getAverageGrade() < minAverageGrade) minAverageGrade = student.getAverageGrade();
        }

        for (Student student: students) {
            if (student.getAverageGrade() == minAverageGrade) studentMin = student;
        }
        return studentMin;

    }
    public void expel(Student student) {
        students.remove(student);
    }

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


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}