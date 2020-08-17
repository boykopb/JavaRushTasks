package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/
/*
c:/1.txt
c:/2.txt
c:/3.txt
exit
 */

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        while (!fileName.equals("exit")) {
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
            readThread.join();
            fileName = reader.readLine();

        }
       // for (Map.Entry<String, Integer> map : resultMap.entrySet()) System.out.println(map.getKey() + " " + map.getValue());

    }

    public static class ReadThread extends Thread {
        private String fileName;
        ArrayList<Integer> list = new ArrayList<>();

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {

            try {
                FileInputStream fis = new FileInputStream(fileName);
                int[] array = new int[256];

                while (fis.available() > 0) array[fis.read()]++;
                fis.close();
                int maxRepeat = 0;
                for (int i = 0; i <array.length  ; i++) {
                    if (array[i]>maxRepeat) maxRepeat = array[i];
                }
                for (int i = 0; i <array.length ; i++) {
                    if (array[i]==maxRepeat) resultMap.put(fileName, i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
