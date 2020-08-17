package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        ArrayList<String> months = new ArrayList<String>(Arrays.asList("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December"));



        String readMonth = reader.readLine();

        for (int i = 0; i < months.size(); i++) {
            if (readMonth.equals(months.get(i))){
                System.out.printf("%s is the %d month",readMonth,i+1);
            }

        }


    }
}
