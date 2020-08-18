package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bf = new BufferedReader(fileReader);
        FileWriter writer = new FileWriter(args[1]);
        while (bf.ready()) {
            String[] s = bf.readLine().split(" ");
            for (String value : s) {
                if (value.matches(".*[0-9]+.*")) writer.write(value + " ");
            }
        }
        fileReader.close();
        writer.close();
    }
}
