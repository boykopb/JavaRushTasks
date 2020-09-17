package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.deleteFile(allFilesContent);
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        ArrayList<Path> listOfPaths = new ArrayList<>();
        try {
            SimpleFileVisitor visitor = new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                    if (path.toFile().length() <= 50 && !path.toFile().isDirectory()) {
                        listOfPaths.add(path);
                    }
                    return FileVisitResult.CONTINUE;
                }
            };
            Files.walkFileTree(path, visitor);
            listOfPaths.sort((o1, o2) -> o1.toFile().getName().compareToIgnoreCase(o2.toFile().getName()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(allFilesContent));
        for (Path file : listOfPaths) {
            //System.out.println(file.toFile().getName() + " записан || путь к файлу:" + file.toString());
            Solution sol = new Solution();
            sol.write(writer, file.toFile());
        }
        writer.close();

    }

    private void write(BufferedWriter writer, File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            writer.write(reader.readLine());
            writer.newLine();
        }
        reader.close();
    }
}


