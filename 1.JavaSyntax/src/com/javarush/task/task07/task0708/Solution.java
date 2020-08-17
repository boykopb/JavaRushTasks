package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Solution.strings = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Solution.strings.add(reader.readLine());
        }

        int max = 0;
        for (int i = 0; i < Solution.strings.size(); i++) {
            if (Solution.strings.get(i).length() >max){
                max = Solution.strings.get(i).length();
            }

        }
        for (int i = 0; i < Solution.strings.size(); i++) {
            if (Solution.strings.get(i).length() == max){
                System.out.println(Solution.strings.get(i));

            }

        }
    }
}
