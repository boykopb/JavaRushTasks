package com.javarush.task.task04.task0443;

/* 
Как назвали, так назвали
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String name = "Вася";
        int y = 1980;
        int m = 11;
        int d = 20;

        System.out.printf("Меня зовут %s.\nЯ родился %d.%d.%d", name, d,m,y);
    }
}
