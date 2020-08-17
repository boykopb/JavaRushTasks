package com.javarush.task.task04.task0434;

/* 
Таблица умножения Ӏ Java Syntax: 4 уровень, 10 лекция
*/

public class Solution {
    public static void main(String[] args) {
        int a = 1;
        int cnt = 1;
        while (cnt < 11) {
            while (a < 11) {
                System.out.print(a * cnt +  " ");
                a++;
            }
            a = 1;
            cnt++;
            System.out.println();
        }
    }
}
