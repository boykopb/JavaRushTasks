package com.javarush.task.task08.task0815;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> treeMap = new HashMap<>();
        treeMap.put("Иванов", "Иван");
        treeMap.put("Петров", "Василий");
        treeMap.put("Метров", "Николай");
        treeMap.put("Мудров", "Евгений");
        treeMap.put("Брежнина", "Леонид");
        treeMap.put("Иванов1", "Иван");
        treeMap.put("Петров1", "Василий");
        treeMap.put("Метров1", "Николай");
        treeMap.put("Мудров1", "Евгеныч");
        treeMap.put("Брежнин", "Леонидыч");

        return treeMap;

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int countName = 0;

        for(Map.Entry<String,String> pair: map.entrySet()){
            if(pair.getValue().equals(name)) {
                countName++;
            }
        }
        return countName;

    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int countLastName = 0;

        for(Map.Entry<String,String> pair: map.entrySet()){
            if(pair.getKey().equals(lastName)) {
                countLastName++;
            }
        }

        return countLastName;

    }

    public static void main(String[] args) {

    }
}
