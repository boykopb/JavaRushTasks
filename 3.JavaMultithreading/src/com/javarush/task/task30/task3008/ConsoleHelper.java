package com.javarush.task.task30.task3008;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String readStr = "";
        try {
            readStr = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Ошибка в методе readString класса ConsoleHelper. Попробуйте еще раз.");
            readStr = readString();
        }
        return readStr;
    }

    public static int readInt() {
        int readInt = 0;
        try {
            readInt = Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка в методе readInt класса ConsoleHelper. Вводите только цифры.");
            readInt = Integer.parseInt(readString());
        }
        return readInt;
    }
}
