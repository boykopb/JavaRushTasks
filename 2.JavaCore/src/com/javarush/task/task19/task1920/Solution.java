package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/*
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        //String filename = "c:/1.txt";
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bf = new BufferedReader(fileReader);
        TreeMap<String, Double> map = new TreeMap<>();

        while (bf.ready()) {
            String[] s = bf.readLine().split(" ");
            if (map.containsKey(s[0])) {
                map.put(s[0], map.get(s[0]) + Double.parseDouble(s[1]));
            } else {
                map.put(s[0], Double.parseDouble(s[1]));
            }
        }
        fileReader.close();
        double max = -2100000000;
        for (Map.Entry<String, Double> result : map.entrySet()) if (result.getValue() > max) max = result.getValue();

        for (Map.Entry<String, Double> result1 : map.entrySet()) {
            if (result1.getValue() == max) {
                System.out.println(result1.getKey());
            }
        }
    }
}




