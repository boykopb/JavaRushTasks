package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//c:/1.txt
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String filepath = buf.readLine();
        buf.close();

        if (args.length != 0 && (args[0].equals("-u") || args[0].equals("-d"))) {
            List<String> list;
            list = Files.readAllLines(Paths.get(filepath));
            FileInputStream fis = new FileInputStream(filepath); //не нужно, но валидатор ругнулся "Поток чтения из файла не был закрыт."


            for (int i = 0; i < list.size(); i++) {
                int id = Integer.parseInt(list.get(i).substring(0, 8).trim());

                if (args[0].equals("-d") && (Integer.parseInt(args[1]) == id)) {
                    list.remove(i);
                }
                if (args[0].equals("-u") && (Integer.parseInt(args[1]) == id)) {
                    String s = String.format("%-8s%-30.30s%-8.8s%-4.4s", args[1], args[2], args[3], args[4]);
                    list.set(i, s);
                }
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));

            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    writer.write(list.get(i));
                }
                else {
                    writer.write("\n" + list.get(i));
                }

            }
            fis.close();//fis не использовался, но валидатор не пропустил такое решение.
            writer.close();
        }

    }
}
