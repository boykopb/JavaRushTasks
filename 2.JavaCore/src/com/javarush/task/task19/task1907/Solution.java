package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        br.close();
        FileReader reader = new FileReader(file);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            char data = (char) reader.read();
            sb.append(data);
        }
        reader.close();
        for (String element : sb.toString().split(("\\W"))) {
            if (element.equals("world")) count++;
        }
        System.out.println(count);
    }
}
