package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }


    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        Integer median = 0;
        if (array.length % 2 != 0) median = array[array.length / 2];
        else median = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;

        final Integer comparatorMedian = median;
        Comparator<Integer> com=new Comparator<Integer>(){
            public int compare(Integer int1,Integer int2){
                return (Math.abs(comparatorMedian-int1)-Math.abs(comparatorMedian-int2));
            }
        };
        Arrays.sort(array,com);
        return array;
    }
}
