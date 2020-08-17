package com.javarush.task.task08.task0802;

/* 
Map из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Map<String,String> hashSet = new HashMap<String,String>();

        hashSet.put("арбуз", "ягода");
        hashSet.put("банан", "трава");
        hashSet.put("вишня", "ягода");
        hashSet.put("груша", "фрукт");
        hashSet.put("дыня", "овощ");
        hashSet.put("ежевика", "куст");
        hashSet.put("жень-шень", "корень");
        hashSet.put("земляника", "ягода");
        hashSet.put("ирис", "цветок");
        hashSet.put("картофель", "клубень");

        for(Map.Entry<String,String> pair : hashSet.entrySet()){
            String key = pair.getKey();
            String val = pair.getValue();
            System.out.println(key +" - " + val);
        }

    }
}
