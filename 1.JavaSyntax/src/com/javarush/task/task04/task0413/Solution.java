package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());

        dayOfTheWeek(t);


    }

    public static void dayOfTheWeek(int a) {
        String s = "такого дня недели не существует";

        if (a == 1) {
            s = "понедельник";
        }
        if (a == 2) {
            s = "вторник";
        }
        if (a == 3) {
            s = "среда";
        }
        if (a == 4) {
            s = "четверг";
        }
        if (a == 5) {
            s = "пятница";
        }
        if (a == 6) {
            s = "суббота";
        }
        if (a == 7) {
            s = "воскресенье";
        }
        System.out.println(s);
    }
}