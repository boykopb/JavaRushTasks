package com.javarush.task.task07.task0702;

/* 
Массив из строчек в обратном порядке
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] a = new String[10];

        for (int i = 0; i < 8; i++) {
            String keyboard = reader.readLine();
            a[i] = keyboard;
        }

        for (int i = 9; i >= 0; i--) {

            System.out.println(a[i]);
        }
    }
}