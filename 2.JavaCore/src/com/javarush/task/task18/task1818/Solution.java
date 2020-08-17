package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {



        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        reader.close();

        //считываем файл 2
        FileInputStream fileIn2 = new FileInputStream(file2);
        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();


        while (fileIn2.available() > 0) {
            bAOS.write(fileIn2.read());
        }
        fileIn2.close();

        FileInputStream fileIn3 = new FileInputStream(file3);

        while (fileIn3.available() > 0) {
            bAOS.write(fileIn3.read());
        }
        fileIn3.close();


        FileOutputStream fos = new FileOutputStream(file1,true);
        fos.write(bAOS.toByteArray());

        fos.close();
        bAOS.close();


    }
}
