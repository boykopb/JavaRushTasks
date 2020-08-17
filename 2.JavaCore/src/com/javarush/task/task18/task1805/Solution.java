package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();
        while (fis.available() > 0) {
            treeSet.add(fis.read());
        }
        fis.close();

        for (Integer i : treeSet) System.out.print(i + " ");
    }
}
