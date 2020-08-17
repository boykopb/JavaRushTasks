package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
//c:/1.txt
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String filepath = buf.readLine();
        buf.close();

        if (args.length != 0) {
            BufferedReader reader = new BufferedReader (new FileReader(filepath));

           while (reader.ready()) {
               String str = reader.readLine();
               if (str.startsWith(args[0] + " ")) {
                   System.out.println(str);
               }

            }
            reader.close();
        }

    }
}
