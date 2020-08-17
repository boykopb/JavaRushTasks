package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        FileInputStream fileIn = new FileInputStream(name);
        int max =-2100000000;
        while (fileIn.available() >0){
            int a = fileIn.read();
            if (a>max){
                max = a;
            }
        }
        fileIn.close();
        System.out.println(max);


    }
}
