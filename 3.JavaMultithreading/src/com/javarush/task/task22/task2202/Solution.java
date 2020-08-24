package com.javarush.task.task22.task2202;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));

    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty()) throw new TooShortStringException();

        String result = "";
        String [] temp = string.split(" ");
        try {
            result = temp[1] + " " + temp[2] + " " + temp[3] + " " + temp[4];
        }catch (RuntimeException e){
                throw new TooShortStringException();

        }
        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
