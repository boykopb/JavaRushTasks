package com.javarush.task.task12.task1220;

/* 
Класс Human и интерфейсы CanRun, CanSwim
*/

public class Solution {
    public static void main(String[] args) {

    }

    //add public interfaces and a public class here - добавь public интерфейсы и public класс тут
    interface CanSwim {
        void Swimming();

    }


    interface CanRun {
        void Running();

    }


    public abstract class Human implements CanRun, CanSwim{

    }
}
