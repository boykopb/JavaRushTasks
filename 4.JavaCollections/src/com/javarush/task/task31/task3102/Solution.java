package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static class MyFileVisitor extends SimpleFileVisitor {
        List<String> result = new ArrayList<>();
        @Override
        public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
            Path file1 = (Path) file;
            result.add(file1.toAbsolutePath().toString());
            return FileVisitResult.CONTINUE;
        }

    }


    public static List<String> getFileTree(String root) throws IOException {
        Path path = Paths.get(root);
        MyFileVisitor a = new MyFileVisitor();
        Files.walkFileTree(path, a);
        return a.result;

    }

    public static void main(String[] args) throws IOException {
        String root = "C:\\wer";
        System.out.println(Arrays.toString(getFileTree(root).toArray()));

    }
}
