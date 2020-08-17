package com.javarush.task.task18.task1802;

/* 
Минимальный байт
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
        int min =2100000000;
        while (fileIn.available() >0){
            int a = fileIn.read();
            if (a<min){
                min = a;
            }
        }
        fileIn.close();
        System.out.println(min);
    }
}
