package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            long number = Long.parseLong(args[1]);
            long length = raf.length();
            number = number > length ? length : number;
            String text = args[2];
            raf.seek(number);
            raf.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
