package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("сын Ваня", true, 7);
        Human child2 = new Human("сын Даня", true, 12);
        Human child3 = new Human("дочь Ира", false, 15);

        ArrayList<Human> littleKids = new ArrayList<>();
        littleKids.add(child1);
        littleKids.add(child2);
        littleKids.add(child3);


        Human father = new Human("папа Вася", true, 40,littleKids);
        Human mother = new Human("мама Дуся", false, 39,littleKids);

        ArrayList<Human> parentKids1 = new ArrayList<>();
        parentKids1.add(father);
        ArrayList<Human> parentKids2 = new ArrayList<>();
        parentKids2.add(mother);

        Human ded1 = new Human("дед Матвей", true, 75,parentKids1);
        Human baba1 = new Human("баба Глаша", false, 75,parentKids1);

        Human ded2 = new Human("дед Балда", true, 70,parentKids2);
        Human baba2 = new Human("баба Джигурда", false, 71,parentKids2);

        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(ded1.toString());
        System.out.println(baba1.toString());
        System.out.println(ded2.toString());
        System.out.println(baba2.toString());
    }

    public static class Human {
        //напишите тут ваш код

         String name;
         boolean sex;
         int age;
         ArrayList<Human> children;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.children !=null) {
                int childCount = this.children.size();
                    text += ", дети: " + this.children.get(0).name;

                    for (int i = 1; i < childCount; i++) {
                        Human child = this.children.get(i);
                        text += ", " + child.name;
                    }
            }
            return text;
        }
    }
}
