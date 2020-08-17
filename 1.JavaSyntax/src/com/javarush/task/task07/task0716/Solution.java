package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код
        //adding
        for (int i = strings.size()-1; i >= 0 ; i--) {
            if (!strings.get(i).contains("р") && strings.get(i).contains("л")){
                   strings.add(strings.get(i));
            }
        }


        //removing
        for (int i = strings.size()-1; i >= 0 ; i--) {
            if (!strings.get(i).contains("л") && strings.get(i).contains("р")){
                strings.remove(i);
            }
        }
        return strings;
    }
}