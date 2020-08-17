package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        int[] array = getInts();

        int maximum = -2100000000;
        int minimum = 2100000000;

        //напишите тут ваш код
        for (int i = 0; i < array.length; i++) {
            if (array[i]>maximum){
                maximum = array[i];
            }
            if (array[i] <minimum){
                minimum = array[i];
            }
        }


        System.out.print(maximum + " " + minimum);

    }

    //напишите тут ваш код
    static public int[] getInts() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        return array;
    }
}
