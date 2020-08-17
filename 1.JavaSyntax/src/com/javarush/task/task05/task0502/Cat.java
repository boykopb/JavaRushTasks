package com.javarush.task.task05.task0502;

/*
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int ageScore = Integer.compare(this.age, anotherCat.age);
        int weightScore = Integer.compare(this.weight, anotherCat.weight);
        int strScore = Integer.compare(this.strength, anotherCat.strength);
        int totalScore = ageScore + weightScore + strScore;

        return totalScore > 0;
    }

    public static void main(String[] args) {

    }
}

