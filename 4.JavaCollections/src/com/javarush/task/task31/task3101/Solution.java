package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

/* 
Проход по дереву файлов
*/

/*

1) Для обхода дерева файлов и каталогов использовал Files.walkFileTree() с анонимным классом SimpleFileVisitor.
Очень удобная штука, есть инфа в инете.
2) В методе visitFile() этого же класса проверяйте чтобы файл не был директорией и чтобы его length была <= 50.
3) Сортировку делал так: все файлы прошедшые требования выше добавлял в TreeSet.
В сет вставил компаратор по getName (Comparator.comparing(File::getName))
4) Не мог сразу понять метод FileUtils.renameFile(). Нужно создать два файла: первый с именем заданным в параметрах
программы, второй с таким именем: firstFile.getParent() + "/allFilesContent.txt". Потом вызываем на них renameFile()
 метод. Кажется, он просто удалит первый файл и создаст вместо него второй. Кстати, обернул метод renameFile()
 в проверку FileUtils.isExist() - валидатор принял.
5) Записывал содержимое файлов с помощью FileWriter/Reader завернутих в BufferedWriter/Reader
(не забудьте добавить true в конструктор FileWriter). Использовал конструкцию try-with-resources.
 */
public class Solution {
    public static void main(String[] args) {

        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);



    }
}
