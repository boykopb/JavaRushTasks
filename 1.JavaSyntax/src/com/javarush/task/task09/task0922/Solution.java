package com.javarush.task.task09.task0922;

/* 
Какое сегодня число?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        SimpleDateFormat dateFormatIn = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        SimpleDateFormat dateFormatOut = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        Date readDate = dateFormatIn.parse(buff.readLine());
        System.out.println(dateFormatOut.format(readDate).toUpperCase());


    }
}
