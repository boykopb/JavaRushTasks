package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код
        Cat cat1 = new Cat("Vasiliy", 3, 5, 6);
        Cat cat2 = new Cat("Murka", 2, 3, 4);
        Cat cat3 = new Cat("Barsik", 10, 10, 2);

        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat3));
        System.out.println(cat1.fight(cat3));


    }

    public static class Cat {

        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int ageScore = Integer.compare(this.age, anotherCat.age);
            System.out.println(ageScore);
            int weightScore = Integer.compare(this.weight, anotherCat.weight);
            System.out.println(weightScore);

            int strengthScore = Integer.compare(this.strength, anotherCat.strength);
            System.out.println(strengthScore);


            int score = ageScore + weightScore + strengthScore;
            return score > 0; // return score > 0 ? true : false;
        }
    }
}
