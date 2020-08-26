package com.javarush.task.task22.task2207;


import java.io.*;

import java.util.*;

/*
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //читаем имя файла с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine(); //"c:/1.txt";  //
        reader.close();

        ArrayList<String> wordsList = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = br.readLine()) != null) {
                for (String word : str.split("\\s+")) {
                    if (!word.isEmpty())
                        wordsList.add(word);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        int wordCount = wordsList.size();
        for (int i = 0; i < wordCount; i++) {
            if (wordsList.get(i) == null) {
                continue;
            }
            for (int j = i+1; j < wordCount; j++) {
                if (wordsList.get(j) == null) {
                    continue;
                }
                String rev = new StringBuilder(wordsList.get(j)).reverse().toString();
                if (wordsList.get(i).equals(rev)) {
                    Pair pair1 = new Pair(wordsList.get(i), wordsList.get(j));
                    result.add(pair1);
                    wordsList.set(i,null);
                    wordsList.set(j,null);
                    break;
                }
            }
        }

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
