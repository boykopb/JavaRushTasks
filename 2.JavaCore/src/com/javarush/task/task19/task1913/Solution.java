package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream ps = System.out;
        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(bAOS);
        System.setOut(stream);
        testString.printSomething();
        String result = bAOS.toString();

        System.setOut(ps);


        System.out.println(result.replaceAll("[^0-9]", ""));



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
