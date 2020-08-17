package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 0) {
            String fileName  = args[1];
            String fileOutputName  = args[2];
            FileInputStream fileInputStream = new FileInputStream(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);


            switch (args[0]) {
                case "-e":
                    while (fileInputStream.available() >0) {
                        fileOutputStream.write(fileInputStream.read()+1);
                    }
                    break;
                case "-d":

                    while (fileInputStream.available() >0) {
                        fileOutputStream.write(fileInputStream.read()-1);
                    }
                    break;
            }
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
