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
        BigInteger bigInteger;
        try {
            for (int i = 2; i <= 36; i++) {
                try {
                    bigInteger = new BigInteger(args[0], i);
                    System.out.println(i);
                    return;
                } catch (Exception e) {
                }
            }
            System.out.println("incorrect");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}