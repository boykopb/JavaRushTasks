package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/
public class Solution {
    public static class MyFileVisitor extends SimpleFileVisitor{
        public int totalCountDirectory = 0;
        int totalCountFiles = 0;
        long totalSize = 0;

        @Override
        public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
            Path file1 = (Path) file;
            totalCountFiles++;
            totalSize+= Files.readAllBytes(file1).length;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
            totalCountDirectory++;
            return FileVisitResult.CONTINUE;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        Path path1 = Paths.get(path);
        MyFileVisitor a = new MyFileVisitor();
        if (!Files.isDirectory(path1))
            System.out.println(path1.toAbsolutePath().toString() + " - не папка");
        else{
            Files.walkFileTree(path1,a);
            System.out.println("Всего папок - " + (a.totalCountDirectory-1));
            System.out.println("Всего файлов - " + a.totalCountFiles);
            System.out.println("Общий размер - " + a.totalSize);}
    }
}
