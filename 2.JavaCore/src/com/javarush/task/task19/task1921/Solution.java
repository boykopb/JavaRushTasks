package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/
/*
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
 */
public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {

        String filename = args[0];//"c:/1.txt";

        FileReader reader = new FileReader(filename);
        BufferedReader bf = new BufferedReader(reader);

        while (bf.ready()) {
            String readline = bf.readLine();
            String[] line = readline.split(" ");

            String dayOfBirth = line[line.length-3];
            String monthOfBirth = line[line.length-2];
            String yearOfBirth = line[line.length-1];

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            String name = readline.substring(0, readline.indexOf(" " + dayOfBirth));
            Date birthDate = dateFormat.parse(dayOfBirth + " " + monthOfBirth + " " + yearOfBirth);

            PEOPLE.add(new Person(name,birthDate));
        }
        reader.close();
        bf.close();

    }
}
