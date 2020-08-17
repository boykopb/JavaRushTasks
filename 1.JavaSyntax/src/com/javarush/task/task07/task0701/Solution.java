package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] a = new int[20];

        for (int i = 0; i < 20; i++) {
            int keyboard = Integer.parseInt(reader.readLine());
            a[i] = keyboard;
        }
        return a;
    }

    public static int max(int[] array) {
        // найди максимальное значение
        int max = -2000000000;
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max) max = array[i];
        }
        return max;
    }
}
