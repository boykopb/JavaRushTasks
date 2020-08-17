package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileInput = bufferedReader.readLine();
        String fileOutput = bufferedReader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileInput));
        String[] s = new String[0];
        while (fileReader.ready()) {
            s = fileReader.readLine().split(" ");
        }

        BufferedWriter fileWriter= new BufferedWriter(new FileWriter (fileOutput));

        for (int i = 0; i < s.length; i++) {
            try {
                int a = Integer.parseInt(s[i]);
                fileWriter.write(a + " ");
            } catch (NumberFormatException e) {
                continue;
            }

        }

        bufferedReader.close();
        fileReader.close();
        fileWriter.close();

    }
}
