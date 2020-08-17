package com.javarush.task.task07.task0705;

/* 
Один большой массив и два маленьких
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] a = new int[20];

        for (int i = 0; i < 20; i++) {
            int keyboard = Integer.parseInt(reader.readLine());
            a[i] = keyboard;
        }
        int [] b = new int[10];
        int [] c = new int[10];
        for (int i = 0; i < 10; i++) {
            b[i] = a[i];
            c[i] = a[i+10];
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(c[i]);
        }

    }
}
