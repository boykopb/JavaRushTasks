package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String filename = read.readLine();
        BufferedWriter write = new BufferedWriter(new FileWriter(filename));

        while (true) {
            String s = read.readLine();
            write.write(s);
            write.newLine();
            if (s.equals("exit")) {
                break;
            }

        }

        read.close();
        write.close();

    }


}
