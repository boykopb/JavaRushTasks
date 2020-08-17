package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. step 3 - пункт 3
        cats.remove(cats.toArray()[0]);

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        Set<Cat> newCat = new HashSet<>();
        newCat.add(new Cat());
        newCat.add(new Cat());
        newCat.add(new Cat());

        return newCat;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        for (Cat c: cats) {
            System.out.println(c);
        }
    }

    // step 1 - пункт 1
    public static class Cat {

        public Cat() {
        }
    }
}
