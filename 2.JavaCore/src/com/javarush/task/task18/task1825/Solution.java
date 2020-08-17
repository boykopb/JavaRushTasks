package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {

        TreeSet<String> set = new TreeSet<>();

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        String filename = buf.readLine();
        while (!filename.equals("end")) {
            set.add(filename);
            filename = buf.readLine();
        }
        FileOutputStream fos = new FileOutputStream(set.first().substring(0, set.first().lastIndexOf(".part")));

        for (String name : set) {
            FileInputStream fis = new FileInputStream(name);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fos.write(buffer);
            fis.close();
        }
        fos.close();


    }
}
