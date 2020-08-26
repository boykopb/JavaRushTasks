package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName =   reader.readLine(); // "c:/1.txt"; //
        reader.close();

        StringBuilder sbInput = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = br.readLine()) != null) {
                sbInput.append(str + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] total = sbInput.toString().split(" ");
        StringBuilder result = getLine(total);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length > 0) {
            StringBuilder resultOutput = new StringBuilder();
            ArrayList<String> list = new ArrayList<>(Arrays.asList(words));

            resultOutput.append(list.get(0)).append(" ");
            list.remove(0);
            int badWrdCnt = 0;

            while (!list.isEmpty()) {
                if (Character.toLowerCase(list.get(0).charAt(0)) == Character.toLowerCase(resultOutput.charAt(resultOutput.length() - 2))) {
                    resultOutput.append(list.get(0)).append(" ");
                   // System.out.println("В конец списка => " + list.get(0));
                   // System.out.println("Текущий список: " + resultOutput.toString());
                    list.remove(0);
                    badWrdCnt = 0;
                    if (list.size()  == 0) break;
                }
                if (Character.toLowerCase(list.get(0).charAt(list.get(0).length() - 1)) == Character.toLowerCase(resultOutput.charAt(0))) {
                    resultOutput.insert(0, list.get(0) + " ");
                   // System.out.println("В начало списка => " + list.get(0));
                   // System.out.println("Текущий список: " + resultOutput.toString());
                    list.remove(0);
                    badWrdCnt = 0;
                    if (list.size()  == 0) break;

                } else {
                    String badWord = list.get(0);
                   // System.out.println(String.format("badWord = %s, badWrdCnt = %d", badWord, badWrdCnt));
                    list.remove(0);
                    list.add(badWord);
                    badWrdCnt++;
                    if (list.size() == badWrdCnt) {
                        break;
                    }
                }
            }
            for (String s : list) {
                resultOutput.append(s).append(" ");
            }
            return resultOutput.deleteCharAt(resultOutput.toString().length() - 1);
        } else {
            return new StringBuilder();
        }

    }
}
