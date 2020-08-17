package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> s = new ArrayList<>();

        for(Map.Entry<String,String> pair: map.entrySet()){
            s.add(pair.getValue());
        }

        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.size(); j++) {
                if (i != j && s.get(i).equals(s.get(j))){
                    removeItemFromMapByValue (map, s.get(i));
                }

            }
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {


    }
}
