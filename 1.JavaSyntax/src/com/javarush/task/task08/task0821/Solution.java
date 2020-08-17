package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Иванов", "Иван");
        map.put("Иванов1", "Иван1");
        map.put("Иванов2", "Иван2");
        map.put("Иванов3", "Иван");
        map.put("Иванов4", "Иван1");
        map.put("Иванов2", "Иван22");
        map.put("Иванов5", "Иван");
        map.put("Иванов6", "Иван1");
        map.put("Иванов5", "Иван77");
        map.put("Иванов5", "Иван33");

        return map;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
