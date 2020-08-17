package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

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
                    synchronized (allPeople)
                    {
                        for (int i = 1; i < args.length; i+=3) {
                            name = args[i];
                            sex = args[i+1].equals("м") ? Sex.MALE : Sex.FEMALE;
                            bd = dateFormat.parse(args[i+2]);
                            if (sex == Sex.MALE) {
                                p = Person.createMale(name, bd);
                            } else {
                                p = Person.createFemale(name, bd);
                            }
                            allPeople.add(p);
                            System.out.println(allPeople.indexOf(p));
                        }
                    }
                    break;

                case "-u":
                    synchronized (allPeople){
                        for (int i = 1; i < args.length; i+=4) {
                            id = Integer.parseInt(args[i]);
                            name = args[i+1];
                            sex = args[i+2].equals("м") ? Sex.MALE : Sex.FEMALE;
                            bd = dateFormat.parse(args[i+3]);
                            p = allPeople.get(id);
                            p.setName(name);
                            p.setSex(sex);
                            p.setBirthDate(bd);
                        }
                    }
                    break;

                case "-d":
                    synchronized (allPeople){
                        for (int i = 1; i < args.length; i++) {
                            id = Integer.parseInt(args[i]);
                            p = allPeople.get(id);
                            p.setName(null);
                            p.setSex(null);
                            p.setBirthDate(null);
                        }
                    }
                    break;

                case "-i":
                    synchronized (allPeople){

                        for (int i = 1; i < args.length; i++) {
                            id = Integer.parseInt(args[i]);
                            p = allPeople.get(id);
                            name = p.getName();
                            bd = p.getBirthDate();
                            String sx = (p.getSex() == Sex.MALE) ? "м" : "ж";
                            SimpleDateFormat bdOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                            System.out.println(name + " " + sx + " " + bdOutput.format(bd));
                        }
                    }

                    break;
            }

        }
    }
}
