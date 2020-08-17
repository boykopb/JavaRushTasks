package com.javarush.task.task06.task0610;

/* 
Класс ConsoleReader
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader {
    public static String readString() throws Exception {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String line = buff.readLine();
        return line;

    }

    public static int readInt() throws Exception {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int intNum = Integer.parseInt(buff.readLine());
        return intNum;

    }

    public static double readDouble() throws Exception {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        double doubleNum = Double.parseDouble(buff.readLine());
        return doubleNum;
    }

    public static boolean readBoolean() throws Exception {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        boolean booleanLine = Boolean.parseBoolean(buff.readLine());
        return booleanLine;
    }

    public static void main(String[] args) throws Exception {

    }
}
