package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileInput = bufferedReader.readLine();
        String fileOutput = bufferedReader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileInput));
        BufferedWriter fileWriter= new BufferedWriter(new FileWriter(fileOutput));

        while (fileReader.ready()) {
            char c = (char) fileReader.read();
            if(c == '.') c = '!';
            fileWriter.write(c);
        }

        bufferedReader.close();
        fileReader.close();
        fileWriter.close();


    }
}
