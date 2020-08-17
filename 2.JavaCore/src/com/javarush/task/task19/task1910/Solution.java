package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileInput = bufferedReader.readLine();
        String fileOutput = bufferedReader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileInput));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileOutput));

        while (fileReader.ready()) {
            String s = fileReader.readLine().replaceAll("\\pP", "");
            fileWriter.write(s);
        }

        bufferedReader.close();
        fileReader.close();
        fileWriter.close();
    }
}
