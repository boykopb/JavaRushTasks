package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        long[] array = new long[256];
        while (fis.available()>0) array[fis.read()]++;
        fis.close();
        for (int i = 0; i <array.length ; i++) {
            if (array[i]==1) System.out.print(i + " ");
        }
    }
}
