package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grandFather1 = new Human("Дедушка Ваня", true,65);
        System.out.println(grandFather1.toString());

        Human grandFather2 = new Human("Дедушка Женя", true,67);
        System.out.println(grandFather2.toString());

        Human grandMother1 = new Human("Бабушка Лена", false,60);
        System.out.println(grandMother1.toString());

        Human grandMother2 = new Human("Бабушка Ира", false,61);
        System.out.println(grandMother2.toString());

        Human father = new Human("Папа Коля", true,40, grandFather1, grandMother1);
        System.out.println(father.toString());

        Human mother = new Human("Мама Ира", false,38, grandFather2, grandMother2);
        System.out.println(mother.toString());

        Human daughter1 = new Human("Дочь Аня", false,15, father, mother);
        System.out.println(daughter1.toString());

        Human daughter2 = new Human("Дочь Валя", false,13, father, mother);
        System.out.println(daughter2.toString());

        Human son = new Human("Сын Андрей", true,10, father, mother);
        System.out.println(son.toString());

    }

    public static class Human {
        // напишите тут ваш код
        private String name;
        private int age;
        private boolean sex;
        private Human father;
        private Human mother;

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }

        public Human(String name,boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = null;
            this.mother = null;
        }

        public Human(String name,boolean sex, int age,Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
    }
}