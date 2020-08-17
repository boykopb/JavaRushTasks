package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String name;
        Sex sex;
        Date bd;
        Person p;
        int id;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);


        if (args.length != 0) {

            switch (args[0]) {
                case "-c":
                    name = args[1];
                    sex = args[2].equals("м") ? Sex.MALE : Sex.FEMALE;
                    bd = dateFormat.parse(args[3]);
                    if (sex == Sex.MALE) {
                        p = Person.createMale(name, bd);
                    } else {
                        p = Person.createFemale(name, bd);
                    }
                    allPeople.add(p);
                    System.out.println(allPeople.indexOf(p));
                    break;

                case "-u":
                    id = Integer.parseInt(args[1]);
                    name = args[2];
                    sex = args[3].equals("м") ? Sex.MALE : Sex.FEMALE;
                    bd = dateFormat.parse(args[4]);
                    p = allPeople.get(id);
                    p.setName(name);
                    p.setSex(sex);
                    p.setBirthDate(bd);
                    break;

                case "-d":
                    id = Integer.parseInt(args[1]);
                    p = allPeople.get(id);
                    p.setName(null);
                    p.setSex(null);
                    p.setBirthDate(null);
                    break;

                case "-i":
                    id = Integer.parseInt(args[1]);
                    p = allPeople.get(id);
                    name = p.getName();
                    bd = p.getBirthDate();
                    String sx = (p.getSex() == Sex.MALE) ? "м" : "ж";
                    SimpleDateFormat bdOutput = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
                    System.out.println(name + " " + sx + " " + bdOutput.format(bd));
                    break;
            }

        }


    }
}
