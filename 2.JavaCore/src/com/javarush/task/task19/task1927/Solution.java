package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream ps = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baos);
        System.setOut(stream);

        testString.printSomething();
        String fromPrntSmth = baos.toString();
        System.setOut(ps);


        String [] result = fromPrntSmth.split("\n");

        int cnt = 0;
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            cnt++;
            if (cnt ==2) {
                System.out.println("JavaRush - курсы Java онлайн");
                cnt = 0;
            }

        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
