package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
//C:\qwert\Text.txt
//C:\qwert\2.zip

public class Solution {

    public static void main(String[] args) throws IOException {
        String newFileName = Paths.get(args[0]).getFileName().toString();
        String newPathInArchive = "new/" + newFileName;
        ZipEntry entry;
        Map<String, ByteArrayOutputStream> filesInArchive = new HashMap<>();

        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]));
        while ((entry = zipInputStream.getNextEntry()) != null) {
            if (entry.getName().endsWith(newFileName)) {
                newPathInArchive = entry.getName();
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int length = 0;
                byte[] buffer = new byte[1024];
                while ((length = zipInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, length);
                }
                filesInArchive.put(entry.getName(), byteArrayOutputStream);
            }
        }
        zipInputStream.close();

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]));
        zipOutputStream.putNextEntry(new ZipEntry(newPathInArchive));
        Files.copy(Paths.get(args[0]), zipOutputStream);
        for (Map.Entry<String, ByteArrayOutputStream> pair : filesInArchive.entrySet()) {
            zipOutputStream.putNextEntry(new ZipEntry(pair.getKey()));
            pair.getValue().writeTo(zipOutputStream);
        }
        zipOutputStream.close();
    }

}
