package com.javarush.task.task02.task0210;

/* 
Необъективная реальность
*/
public class Solution {
    public static void main(String[] args) {
        String s = "Будешь плохо кодить, придет Java и съест твою память";
        String s1 = s;
        s1 = "Я все сломал!!";

        System.out.println(s + "======="+s1);
    }
}
