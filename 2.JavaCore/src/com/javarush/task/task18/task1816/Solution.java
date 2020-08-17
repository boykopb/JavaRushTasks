package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(args[0]);
        int cnt = 0;
        while (inputStream.available() >0) {
            char c = (char)inputStream.read();
            if ((c >= 'a' && c <= 'z') || ((c >='A' && c <='Z'))) {
                cnt++;
            }
        }
        inputStream.close();
        System.out.println(cnt);

    }
}
