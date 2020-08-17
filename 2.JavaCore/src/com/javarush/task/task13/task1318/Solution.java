package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String s = buff.readLine();

        FileInputStream inStream = new FileInputStream(s);
        BufferedInputStream buffer = new BufferedInputStream(inStream);

        while (buffer.available() > 0) {

            System.out.print((char) buffer.read());
        }


        inStream.close();
        buffer.close();
        buff.close();

    }


}