package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String path = buff.readLine();
        buff.close();
        FileInputStream inputStream = new FileInputStream(path);
        int cnt = 0;
        while (inputStream.available() >0) {
            int c = inputStream.read();
            if (c == (int)',') cnt++;
        }
        System.out.println(cnt);
        inputStream.close();

    }
}
