package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        BufferedReader keyboardreader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите полный путь к результату архивации");
        String archivePath = keyboardreader.readLine();

        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(archivePath));

        System.out.println("Введите полный путь к файлу, который будем архивировать");
        String filePath = keyboardreader.readLine();
     

        keyboardreader.close();

        zipFileManager.createZip(Paths.get(filePath));




    }


}
