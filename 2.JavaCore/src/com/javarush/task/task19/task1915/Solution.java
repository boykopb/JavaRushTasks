package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        PrintStream psOld = System.out;
        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
        PrintStream psNew = new PrintStream(bAOS);
        System.setOut(psNew);
        testString.printSomething();
        String result = bAOS.toString();
        System.setOut(psOld);
        System.out.println(result);

        FileOutputStream fos = new FileOutputStream(filename);

        fos.write(result.getBytes());
        fos.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

