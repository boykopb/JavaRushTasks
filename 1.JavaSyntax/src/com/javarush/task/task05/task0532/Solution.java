package com.javarush.task.task05.task0532;

/* 
Задача по алгоритмам Ӏ Java Syntax: 5 уровень, 12 лекция
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = -2147483648;
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(reader.readLine());
            if(x>maximum) {
                maximum = x;
            }
        }

        //напишите тут ваш код
        if (n>0) System.out.println(maximum);
    }
}
