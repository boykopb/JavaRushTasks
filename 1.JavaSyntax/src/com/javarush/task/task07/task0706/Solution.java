package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] a = new int[15];
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < 15; i++) {
            int keyboard = Integer.parseInt(reader.readLine());
            a[i] = keyboard;
            if(i == 0 || i%2 == 0){
                evenCount+=keyboard;
            } else{
                oddCount+=keyboard;
            }
        }

        if (evenCount > oddCount){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else{
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }

    }
}
