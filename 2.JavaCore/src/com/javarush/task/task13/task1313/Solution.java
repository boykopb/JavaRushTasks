package com.javarush.task.task13.task1313;

/* 
Лисица — это такое животное
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        String getColor();
    }

    public abstract class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
    }
}