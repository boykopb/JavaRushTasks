package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        int x1 = Integer.parseInt(bufferedReader.readLine());
        int x2 = Integer.parseInt(bufferedReader.readLine());

        System.out.printf("%s получает %d через %d лет.", name,x1,x2);

    }
}
