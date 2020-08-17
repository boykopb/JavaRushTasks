package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String filepath = buf.readLine();
        buf.close();
        if (args.length != 0 && args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            int max = 0;
            while (reader.ready()) {
                int current = Integer.parseInt(reader.readLine().substring(0, 8).trim());
                if (current > max) max = current;
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true));
            writer.newLine();
            writer.write(String.format("%-8d%-30.30s%-8.8s%-4.4s", max + 1, args[1], args[2], args[3]));
            reader.close();
            writer.close();

        }

    }
}
