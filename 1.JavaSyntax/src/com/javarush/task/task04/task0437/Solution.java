package com.javarush.task.task04.task0437;

/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) {
        int stolbci = 10;
        int stroki = 1;

        for (int i = 0; i < stolbci; i++) {
            for (int j = 0; j < stroki; j++) {
                System.out.print("8");
            }
            System.out.println();
            stroki++;
        }



    }
}
