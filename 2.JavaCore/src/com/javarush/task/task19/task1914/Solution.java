package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream ps = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps1 = new PrintStream(baos);
        System.setOut(ps1);
        testString.printSomething();
        String result = baos.toString().replace("\n", "");
        System.setOut(ps);

        String [] resultMass = result.split(" ");
        int a = Integer.parseInt(resultMass[0]);
        int b = Integer.parseInt(resultMass[2]);
        int total = 0;

        switch (resultMass[1]) {
            case "+" :  total = a + b; break;
            case "-" :  total = a - b; break;
            case "*" :  total = a * b; break;

        }




        System.out.println(result+total);



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

