package com.javarush.task.task09.task0906;

/* 
Логирование стек-трейса
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код

        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();

        System.out.println(className + ": "+ methodName + ": " +s);

    }
}
