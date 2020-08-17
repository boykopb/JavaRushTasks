package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception

        //1
        try {
            float i = 1 / 0;
        } catch (NumberFormatException e) {
            exceptions.add(e);
        } catch (ArithmeticException e) {
            exceptions.add(e);
        }

        //2
        try {
            String a = null;
            System.out.println(a.charAt(0));
        }catch (NullPointerException e) {
            exceptions.add(e);
        }

        //3
        try {
            String a = "This is like chipping "; // length is 22
            char c = a.charAt(24); // accessing 25th element
            System.out.println(c);
        }
        catch(StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        //4
        try {
            // Following file does not exist
            File file = new File("E://file.txt");

            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            exceptions.add(e);

        }


        //5
        try {
            // "akki" is not a number
            int num = Integer.parseInt ("akki") ;

            System.out.println(num);
        } catch(NumberFormatException e) {
            exceptions.add(e);
        }


        //6
        try{
            int a[] = new int[5];
            a[6] = 9; // accessing 7th element in an array of
            // size 5
        }
        catch(ArrayIndexOutOfBoundsException e){
            exceptions.add(e);
        }


        //7
        try
        {
            Object ch = new Character('*');
            System.out.println((Byte)ch);
        }
        catch(ClassCastException e)
        {
            exceptions.add(e);
        }

        //8
        try
        {
            int[] nNegArray = new int[-5];
        }
        catch(NegativeArraySizeException e)
        {
            exceptions.add(e);
        }

        Object szStr[] = new String[10];

        //9
        try
        {
            szStr[0] = new Character('*');
        }
        catch(ArrayStoreException e)
        {
            exceptions.add(e);
        }

        //10
        try {
            throw new RuntimeException("Test");

        } catch (RuntimeException e) {
            exceptions.add(e);

        }
    }
}
