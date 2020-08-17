package com.javarush.task.task03.task0309;

/* 
Сумма 5 чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Cat cat = new Cat();
        int a = 5;
        String text = cat + (a + "Cat is ") + cat + a;
        String text1 = a + "Cat is " + cat + a;

        System.out.println(text);
        System.out.println(text1);

    }


    }
     class Cat {
        public static void cho() {

        }
    }
