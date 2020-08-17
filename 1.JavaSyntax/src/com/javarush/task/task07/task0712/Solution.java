package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int min = 2000000000;
        int max = -2000000000;
        int index_min = -1;
        int index_max = -1;

        //adding
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        //comparing max
        for (int i = 0; i <list.size(); i++) {
            if (list.get(i).length() > max) {
                max = list.get(i).length();
                index_max = i;
            }
          }

        //comparing min
        for (int i = 0; i <list.size(); i++) {
            if (list.get(i).length() < min) {
                min = list.get(i).length();
                index_min = i;
            }
        }


        if(index_max > index_min) {
            System.out.println(list.get(index_min));
        } else {
            System.out.println(list.get(index_max));
        }

    }
}
