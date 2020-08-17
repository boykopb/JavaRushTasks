package com.javarush.task.task05.task0529;

/* 
Консоль-копилка
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true){
            String a = buff.readLine();
            if (a.equals("сумма")) break;

            sum +=Integer.parseInt(a);
        }

        System.out.println(sum);

    }
}
