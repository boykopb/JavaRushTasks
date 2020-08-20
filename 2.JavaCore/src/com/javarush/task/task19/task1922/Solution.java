package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String file = buf.readLine(); //c:/1.txt
        buf.close();

        FileReader fr = new FileReader(file);
        BufferedReader fileReader = new BufferedReader(fr);
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] lineMass = line.split(" ");
            int cnt = 0;
            HashSet<String> set = new HashSet<>(Arrays.asList(lineMass));

            for (String inputWord : set) {
                for (String patternWord : words) {
                    if (inputWord.equals(patternWord)) cnt++;
                }
            }
            if (cnt == 2) {
                System.out.println(line);
            }
        }
        fr.close();
        fileReader.close();
    }
}
