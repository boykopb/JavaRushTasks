package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/


public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        try {
            return telNumber.matches("(\\+\\d{2})?(\\(\\d{3}\\)|\\d{3})\\d{3}\\-?\\d{2}\\-?\\d{2}");

        } catch (NullPointerException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+38(050)123-45-678")); // false
        System.out.println(checkTelNumber("123456789")); // false
        System.out.println(checkTelNumber("+38(050)1-23-45-67")); // false
        System.out.println(checkTelNumber("050ххх4567")); // false
        System.out.println(checkTelNumber("0-50(123)456")); // false
        System.out.println(checkTelNumber("(0501)234567")); // false
        System.out.println(checkTelNumber("+38050123456")); // false
        System.out.println(checkTelNumber("+380501234567-")); // false
        System.out.println(checkTelNumber("")); // false
        System.out.println();
        System.out.println(checkTelNumber("0501234560")); // true
        System.out.println(checkTelNumber("+380501234567")); // true
        System.out.println(checkTelNumber("+38(050)12345-67"));// true
        System.out.println(checkTelNumber("+38(050)1234567"));// true
        System.out.println(checkTelNumber("+38050123-45-67"));// true
        System.out.println(checkTelNumber("050123-4567"));// true
        System.out.println(checkTelNumber("0501234567")); // true

    }


}
