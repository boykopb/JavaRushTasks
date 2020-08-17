package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int sp = 0;
        int all = 0;
        while (inputStream.available() >0) {
            all++;
            if (' ' == (char)inputStream.read()) {
                sp++;
            }
        }
        inputStream.close();

        float aim = (float)sp/all;
        System.out.printf("%.2f%n", aim*100);
    }
}
