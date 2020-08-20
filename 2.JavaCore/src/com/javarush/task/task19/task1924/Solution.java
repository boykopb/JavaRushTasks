package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filepath = reader.readLine(); //c:/1.txt
        reader.close();

        FileReader fileReader = new FileReader(filepath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (bufferedReader.ready()) {
            String[] s = bufferedReader.readLine().split(" ");

            for (int i = 0; i < s.length; i++) {
                try {
                    Integer k = Integer.parseInt(s[i]);
                    if (map.containsKey(k))
                        System.out.print(map.get(k) + " ");
                    else
                        System.out.print(s[i] + " ");
                } catch (NumberFormatException e) {
                    System.out.print(s[i] + " ");
                }
            }

            System.out.println();

        }

        fileReader.close();
        bufferedReader.close();


    }
}
