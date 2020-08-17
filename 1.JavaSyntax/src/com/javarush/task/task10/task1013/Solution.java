package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private static String name;
        private static int age;
        private static int height;
        private static String sex;
        private static String eyeColor;
        private static String hobby;

        public Human(){

        }
        public Human(String name){
            Human.name = name;
        }
        public Human(String name, int age){
            Human.name = name;
            Human.age = age;
        }


        public Human(String name, int age, int height){
            Human.name = name;
            Human.age = age;
            Human.height = height;
        }
        public Human(String name, int age, int height, String sex){
            Human.name = name;
            Human.age = age;
            Human.height = height;
            Human.sex = sex;
        }
        public Human(String name, int age, int height, String sex, String eyeColor){
            Human.name = name;
            Human.age = age;
            Human.height = height;
            Human.sex = sex;
            Human.eyeColor = eyeColor;
        }
        public Human(String name, int age, int height, String sex, String eyeColor, String hobby){
            Human.name = name;
            Human.age = age;
            Human.height = height;
            Human.sex = sex;
            Human.eyeColor = eyeColor;
            Human.hobby = hobby;
        }


        public Human(String name,String sex,  int age, int height, String eyeColor, String hobby){
            Human.name = name;
            Human.age = age;
            Human.height = height;
            Human.sex = sex;
            Human.eyeColor = eyeColor;
            Human.hobby = hobby;
        }

        public Human(String sex,  int age,  String eyeColor, String hobby, int height,String name){
            Human.name = name;
            Human.age = age;
            Human.height = height;
            Human.sex = sex;
            Human.eyeColor = eyeColor;
            Human.hobby = hobby;
        }


        public Human(String name,String sex,  int age,  String eyeColor, String hobby,int height){
            Human.name = name;
            Human.age = age;
            Human.height = height;
            Human.sex = sex;
            Human.eyeColor = eyeColor;
            Human.hobby = hobby;
        }

    }
}
