package com.javarush.task.task10.task1019;

/* 
Функциональности маловато!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String index = reader.readLine();

            if (index.isEmpty()) {
                break;
            }
            String name = reader.readLine();
            map.put(name, index);
        }

        for (Map.Entry<String,String> pair : map.entrySet()) {
             String name = pair.getKey();
            String index = pair.getValue();
            System.out.println(index + " " + name);
        }
    }
}
