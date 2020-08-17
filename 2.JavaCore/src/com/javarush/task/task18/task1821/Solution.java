package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<Character, Integer> map = new TreeMap<>();

   //     String s = "c:/1.txt";
        FileInputStream fis = new FileInputStream(args[0]);

        while (fis.available() > 0) {
            char c = (char)fis.read();
            if (c >= '!' && c <= '}') {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) +1);
                }
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                }
            }

        }

        for (Map.Entry<Character, Integer> s1 : map.entrySet()) {

                System.out.println(s1.getKey() + " " + s1.getValue());

        }

        fis.close();

    }
}
