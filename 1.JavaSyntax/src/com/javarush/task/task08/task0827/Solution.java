package com.javarush.task.task08.task0827;

/* 
Работа с датой
*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


public class Solution {
    public static void main(String[] args) throws ParseException {

        System.out.println(isDateOdd("MAY 1 2013"));

    }

    public static boolean isDateOdd(String date) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Calendar currentDay = new GregorianCalendar();
        currentDay.setTime(dateFormat.parse(date));
        int daysInYear = currentDay.get(Calendar.DAY_OF_YEAR);

        if (daysInYear % 2 != 0) {
            return true;
        } else {
            return false;

        }


    }
}
