package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 2 1065"));

        //напишите тут ваш код

        map.put("Кобра", dateFormat.parse("MARCH 11 1950"));
        map.put("Вася", dateFormat.parse("MARCH 4 1990"));
        map.put("Женя", dateFormat.parse("APRIL 6 2000"));
        map.put("Даня", dateFormat.parse("FEBRUARY 5 1980"));
        map.put("Паша", dateFormat.parse("MARCH 11 1940"));
        map.put("!!!Коля!!!!", dateFormat.parse("JUNE 4 1990"));
        map.put("!!!Иря!!!!!", dateFormat.parse("JULY 6 2000"));
        map.put("!!!Жора!!!!", dateFormat.parse("AUGUST 7 1981"));
        map.put("Андрей", dateFormat.parse("DECEMBER 6 1982"));

        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            //получение «пары» элементов
            Map.Entry<String, Date> pair = iterator.next();
            Date month = pair.getValue();        //значение
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(month);
            if (calendar.get(Calendar.MONTH) == 5 || calendar.get(Calendar.MONTH) == 6 || calendar.get(Calendar.MONTH) == 7) {
                iterator.remove();
            }
        }


    }

    public static void main(String[] args) {


    }
}
