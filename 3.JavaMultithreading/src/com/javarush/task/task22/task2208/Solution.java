package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
  /*      Map<String, String> map = new TreeMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", "");

        System.out.println(getQuery(map));
*/

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> m : params.entrySet()) {
            if (m.getValue() != null) {
                sb.append(String.format("%s = '%s' and ", m.getKey(), m.getValue()));

            }

        }
        if (sb.length() > 0) {
            return sb.substring(0, sb.toString().length() - 5);
        } else return "";
    }
}
