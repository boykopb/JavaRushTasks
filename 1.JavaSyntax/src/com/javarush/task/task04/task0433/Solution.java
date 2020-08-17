package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int a = 10;
        int cnt = 10;
        while (cnt>0) {
            while (a > 0) {
                System.out.print("S");
                a--;
            }
            a = 10;
            cnt--;
            System.out.println();
        }

    }
}
