package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());

        plusMinus(t);


    }

    public static void plusMinus (int a) {
        if (a > 0) {
            a= a*2;
        }
        if (a<0){
            a = a+1;
        }
        if (a == 0) {
            a = 0;
        }
        System.out.println(a);
    }

}
