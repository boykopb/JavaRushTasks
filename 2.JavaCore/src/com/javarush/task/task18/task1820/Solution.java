package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        String readString = fileReader.readLine();
        String[] readStringMass = readString.split(" ");


        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));
        for (int i = 0; i < readStringMass.length; i++) {
            fileWriter.write(Math.round(Double.parseDouble(readStringMass[i]))+" ");
        }

        fileReader.close();
        fileWriter.close();



    }
}
