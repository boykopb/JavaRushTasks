package com.javarush.task.task09.task0921;

/* 
Метод в try..catch
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        while (true){
            try {
                list.add(Integer.parseInt(buff.readLine()));
            } catch (NumberFormatException | IOException e){
                for (Integer s : list){
                    System.out.println(s);

                }
                break;

            }
        }


    }
}
