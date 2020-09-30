package com.javarush.task.task30.task3010;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        try {
            for (int i = 2; i <= 36; i++) {
                BigDecimal bi = new BigDecimal(new BigInteger(args[0], i));

            }
        } catch (Exception e) {
            System.out.println("incorrect");
        }
    }
}