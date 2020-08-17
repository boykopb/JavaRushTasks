package com.javarush.task.task07.task0703;

/* 
Общение одиноких массивов
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] a = new String[10];
        int [] b = new int[10];


        for (int i = 0; i < 10; i++) {
            String keyboard = reader.readLine();
            a[i] = keyboard;
            b[i] = a[i].length();
        }

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
