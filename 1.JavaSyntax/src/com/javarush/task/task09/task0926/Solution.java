package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<>();
        int [] a1 = {1,2,3,4,5};
        list.add(a1);

        int [] a2 = {6,7};
        list.add(a2);

        int [] a3 = {8,9,10,11};
        list.add(a3);

        int [] a4 = {12,13,14,15,16,17,18};
        list.add(a4);

        int [] a5 = new int[0];
        list.add(a5);



        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
