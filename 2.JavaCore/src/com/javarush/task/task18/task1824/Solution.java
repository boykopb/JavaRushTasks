package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String filepath = buf.readLine();
            try (FileInputStream fis= new FileInputStream(filepath)) {}
            catch (FileNotFoundException e) {
                System.out.println(filepath);
                break;
            }
        }
    }
}
