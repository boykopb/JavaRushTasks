package com.javarush.task.task03.task0320;

/* 
Скромность украшает программиста
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String name = bufferedReader.readLine();

        System.out.println(name +  " зарабатывает $5,000. Ха-ха-ха!");
    }
}
