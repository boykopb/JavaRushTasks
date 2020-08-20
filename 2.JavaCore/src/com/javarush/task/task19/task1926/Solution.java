package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String file = bf.readLine();
        bf.close();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedFile = new BufferedReader(fileReader);

        while (bufferedFile.ready()) {
            StringBuilder s = new StringBuilder();
            s.append(bufferedFile.readLine());
            System.out.println(s.reverse());
        }
        fileReader.close();
        bufferedFile.close();
    }
}
