package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

/*
Отслеживаем изменения
Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
В оригинальном и редактируемом файлах пустых строк нет.
Пример содержимого по факту:
оригинальный    редактированный    общий
file1:			file2:			результат:(lines)
строка1		строка1			SAME строка1
строка2		строка3			REMOVED строка2
строка3		строка5			SAME строка3
строка4		строка0			REMOVED строка4
строка5		строка1			SAME строка5
строка1		строка3			ADDED строка0
строка2		строка5			SAME строка1
строка3		строка4			REMOVED строка2
строка4					SAME строка3
строка5					ADDED строка5
						SAME строка4
						REMOVED строка5
Требования:
1.Класс Solution должен содержать класс LineItem.
2.Класс Solution должен содержать enum Type.
3.Класс Solution должен содержать публичное статическое поле lines типа List, которое сразу проинициализировано.
4.В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
5.В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6.Программа должна считывать содержимое первого и второго файла (используй FileReader).
7.Потоки чтения из файлов (FileReader) должны быть закрыты.
8.Список lines должен содержать объединенную версию строк из файлов,
	где для каждой строки указана одна из операций ADDED, REMOVED, SAME.
Пример для представления:
оригинальный    редактированный    общий
file1:			file2:			результат:(lines)
строка1		строка1			SAME строка1
строка2					REMOVED строка2
строка3		строка3			SAME строка3
строка4					REMOVED строка4
строка5		строка5			SAME строка5
			строка0			ADDED строка0
строка1		строка1			SAME строка1
строка2					REMOVED строка2
строка3		строка3			SAME строка3
			строка5			ADDED строка5
строка4		строка4			SAME строка4
строка5					REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String oldFile = reader.readLine();
        String newFile = reader.readLine();
        reader.close();

        //считываем старый файл в список list1
        BufferedReader readOldFile = new BufferedReader(new FileReader(oldFile));
        ArrayList<String> list1 = new ArrayList<>();
        while (readOldFile.ready()) {
            list1.add(readOldFile.readLine());
        }
        readOldFile.close();

        //считываем новый файл в список list2
        BufferedReader readNewFile = new BufferedReader(new FileReader(newFile));
        ArrayList<String> list2 = new ArrayList<>();
        while (readNewFile.ready()) {
            list2.add(readNewFile.readLine());
        }
        readNewFile.close();

        while (list1.size() > 0 && list2.size() > 0) {
            if (list1.get(0).equals(list2.get(0))) {
                lines.add(new LineItem(Type.SAME, list1.get(0)));
                list1.remove(0);
                list2.remove(0);

            } else if (list1.get(1).equals(list2.get(0))) {
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                list1.remove(0);
            } else if (list1.get(0).equals(list2.get(1))) {
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(0);
            }
        }

        if (list1.size() > 0) {
            for (String s : list1) {
                lines.add(new LineItem(Type.REMOVED, s));
            }
        }

        if (list2.size() > 0) {
            for (String s : list2) {
                lines.add(new LineItem(Type.ADDED, s));
            }
        }

        for (LineItem line : lines) {
            System.out.println(line.type + " " + line.line);
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
