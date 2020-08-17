package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(bufferedReader.readLine());
        System.out.println("количество дней в году: " + dayCount(year));
    }


    public static int dayCount(int y) {
        if (y%4 != 0 || y%100 == 0 && y%400 != 0) {
            return 365;
        } else {
            return 366;
        }
    }

}