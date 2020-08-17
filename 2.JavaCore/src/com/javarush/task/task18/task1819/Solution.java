package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
//c:/1.txt
//c:/2.txt
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        //считываем файл 2
        FileInputStream fileIn2 = new FileInputStream(file2);
        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();


        while (fileIn2.available() > 0) {
            bAOS.write(fileIn2.read());
        }
        fileIn2.close();

        FileInputStream fileIn1 = new FileInputStream(file1);

        while (fileIn1.available() > 0) {
            bAOS.write(fileIn1.read());
        }
        fileIn1.close();


        FileOutputStream fileOS = new FileOutputStream(file1);
        bAOS.writeTo(fileOS);
        fileOS.close();
        bAOS.close();

    }
}
