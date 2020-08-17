package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double minute = Double.parseDouble(bufferedReader.readLine());
        currentColor(minute);

    }

    public static void currentColor (double t){
        String color = "зеленый";
        while (t > 5.0) {
            t -=5.0;
        }
        if (t>0.0 && t<3.0) {
            color = "зелёный";
        }
        if (t>=3.0 && t<4.0) {
            color = "желтый";
        }
        if (t>=4.0 && t<5.0) {
            color = "красный";
        }

        System.out.println(color);

    }

}