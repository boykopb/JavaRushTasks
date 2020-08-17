package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        //String filename = "c:/1.txt";

        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bf = new BufferedReader(fileReader);
        TreeMap<String, Double> map = new TreeMap<>();

        while (bf.ready()) {
            String[] s = bf.readLine().split(" ");

            if (map.containsKey(s[0])) {
                map.put(s[0], map.get(s[0]) + Double.parseDouble(s[1]));
            } else {
                map.put(s[0], Double.parseDouble(s[1]));
            }


        }
        fileReader.close();



        for (Map.Entry<String, Double> result : map.entrySet())
            System.out.println(result.getKey() + " " + result.getValue());


    }
}
