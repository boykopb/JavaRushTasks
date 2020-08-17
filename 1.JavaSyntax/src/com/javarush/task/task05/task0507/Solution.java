package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int count =0;

        while (true){
            int a = Integer.parseInt(buff.readLine());

            if (a == -1) break;
            sum +=a;
            count++;
        }

        System.out.println((double)sum/count);
    }
}

