package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек

дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();
        Cat grandFather = new Cat(grandFatherName);

        String grandMotherName = reader.readLine();
        Cat grandMother = new Cat(grandMotherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, null, grandFather);


        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, grandMother,null);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother, catFather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);

        System.out.println(grandFather);
        System.out.println(grandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;



        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString() {
            String text = "";
            if (mother == null && father == null) {
                text = "The cat's name is " + name + ", no mother, no father ";

            }
            if (mother != null && father == null) {
                text = "The cat's name is " + name + ", mother is " + mother.name + ", no father";
            }
            if (mother == null && father != null) {
                text = "The cat's name is " + name + ", no mother, father is " + father.name;
            }
            if (mother != null && father != null) {
                text = "The cat's name is " + name + ", mother is " + mother.name + ", father is " + father.name;
            }
            return text;
        }

    }

}
