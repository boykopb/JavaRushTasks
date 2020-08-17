package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();

        FileReader reader = new FileReader(file1);
        FileWriter writer = new FileWriter(file2);

        int count = 0;

        while (reader.ready()) {
            int data = reader.read();
            count++;
            if (count % 2 == 0) {
                writer.write(data);

            }
        }
        reader.close();
        writer.close();

    }
}
