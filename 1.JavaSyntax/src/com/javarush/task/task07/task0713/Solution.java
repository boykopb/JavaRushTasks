package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> listMain = new ArrayList<>();
        ArrayList<Integer> listBy3 = new ArrayList<>();
        ArrayList<Integer> listBy2 = new ArrayList<>();
        ArrayList<Integer> listOther = new ArrayList<>();


        for (int i = 0; i < 20; i++) {
            listMain.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 0; i < listMain.size(); i++) {
            if (listMain.get(i) % 3 == 0) {
                listBy3.add(listMain.get(i));
            }
            if (listMain.get(i) % 2 == 0) {
                listBy2.add(listMain.get(i));
            }
            if ((listMain.get(i) % 2 != 0) && (listMain.get(i) % 3 != 0)) {
                listOther.add(listMain.get(i));
            }

        }
        printList(listBy3);
        printList(listBy2);
        printList(listOther);

   }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i <list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
