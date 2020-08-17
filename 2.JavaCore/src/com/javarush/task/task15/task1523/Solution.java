package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    private int a;
    private double b;
    private String s;

    public Solution(int a) {
        this.a = a;
    }

    private Solution(double b) {
        this.b = b;
    }

    Solution(String s) {
        this.s = s;
    }

    protected Solution(int a, double b, String s) {
        this.a = a;
        this.b = b;
        this.s = s;
    }

    public static void main(String[] args) {

    }


}

