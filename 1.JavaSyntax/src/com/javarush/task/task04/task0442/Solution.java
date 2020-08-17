package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        while (true) {
            int a = Integer.parseInt(buff.readLine());
            sum += a;

            if (a == -1) {
                break;

            }
        }
        System.out.println(sum);

    }
}
