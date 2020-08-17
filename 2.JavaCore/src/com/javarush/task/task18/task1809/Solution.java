package com.javarush.task.task18.task1809;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String pathIn = buff.readLine();
        FileInputStream fis = new FileInputStream(pathIn);
        String pathOut= buff.readLine();
        FileOutputStream fos = new FileOutputStream(pathOut);
        ArrayList<Integer> list = new ArrayList<>();

        while (fis.available() >0) {
            int count = fis.read();
            list.add(count);
        }
        Collections.reverse(list);

        for (Integer i :list) fos.write(i);

        buff.close();
        fis.close();
        fos.close();
    }
}

/* 
Реверс файла
*/
/*
c:/2.txt
c:/3.txt

 */
