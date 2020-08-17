package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(buff.readLine());
        int b = Integer.parseInt(buff.readLine());
        int c = Integer.parseInt(buff.readLine());

        int max = Math.max(a, Math.max(b,c));
        int min = Math.min(a, Math.min(b,c));


        System.out.println(a+b+c-max-min);

    }
}
