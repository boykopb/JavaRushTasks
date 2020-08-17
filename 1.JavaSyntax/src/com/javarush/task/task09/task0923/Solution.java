package com.javarush.task.task09.task0923;

/* 
Гласные и согласные
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String sIn = buf.readLine();

        ArrayList<Character> vowelsOutput = new ArrayList<>();
        ArrayList<Character> otherOutput = new ArrayList<>();


        for (int i = 0; i < sIn.length(); i++) {
            if (isVowel(sIn.charAt(i))) {
                vowelsOutput.add(sIn.charAt(i));
            } else {
                otherOutput.add(sIn.charAt(i));

            }
        }
        for (int i = 0; i < vowelsOutput.size(); i++) {
            System.out.print(vowelsOutput.get(i) + " ");

        }
        System.out.println();
        for (int i = 0; i < otherOutput.size(); i++) {
            if (!Character.isSpaceChar(otherOutput.get(i))) {
                System.out.print(otherOutput.get(i) + " ");
            }

        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}