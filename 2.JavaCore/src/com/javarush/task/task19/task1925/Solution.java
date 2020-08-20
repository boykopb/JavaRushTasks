package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.StringJoiner;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];

        FileReader fr = new FileReader(file1);
        BufferedReader bfileReader = new BufferedReader(fr);
        FileWriter fileWriter = new FileWriter(file2);

        String []s;
        StringJoiner sj = new StringJoiner(",");

        while (bfileReader.ready()){
            s = bfileReader.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                if (s[i].length() >6) sj.add(s[i]);
            }
        }

        fileWriter.write(sj.toString());
        fr.close();
        bfileReader.close();
        fileWriter.close();

    }
}
