package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // c:/t.txt
        //Вводим путь к к файлу
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String s = buff.readLine();
        buff.close();

        //читаем файл
        BufferedReader inStream = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
        //создаем list для добавления в него чисел из файла
        ArrayList<Integer> list = new ArrayList<>();

        //добавляем четные числа из файла в list
        while (inStream.ready()) {
            int num = Integer.parseInt(inStream.readLine());
            if (num % 2 == 0) {
                list.add(num);
            }
        }
        inStream.close();

        Collections.sort(list);
        for (Integer num : list) {
            System.out.println(num);

        }
    }
}
