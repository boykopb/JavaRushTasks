package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> exList = new ArrayList<>();
        exList.add(e);
        while(exList.get(exList.size()-1).getCause() != null)
            exList.add(exList.get(exList.size()-1).getCause());
        Collections.reverse(exList);

        for (Throwable ex: exList) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {

        new Solution().uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
