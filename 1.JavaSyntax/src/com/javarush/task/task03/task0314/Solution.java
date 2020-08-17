package com.javarush.task.task03.task0314;

/* 
Таблица умножения Ӏ Java Syntax: 3 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        //напишите тут ваш код
        int vertical=1,horizontal=1;
        while(vertical<=10)
        {
            System.out.print(vertical+" ");
            while(horizontal<=9)
            {
                horizontal++;
                System.out.print(vertical*horizontal+" ");
            }
            vertical++;
            horizontal=1;
            System.out.println("");
        }




    }
}
