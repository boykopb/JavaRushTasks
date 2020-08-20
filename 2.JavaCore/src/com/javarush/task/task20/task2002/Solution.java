package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name.tmp", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
          /*  User user = new User();
            user.setFirstName("Rubi");
            user.setLastName("Rail");
            user.setBirthDate(new Date(1508944516168L));
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);

            User user1 = new User();
            user1.setFirstName("Vasa1");
            user1.setLastName("Peta1");
            user1.setBirthDate(new Date(1508944516163L));
            user1.setMale(true);
            user1.setCountry(User.Country.OTHER);

            User user3 = new User();
            user3.setFirstName("Solo");
            user3.setLastName("Han");
            user3.setBirthDate(new Date(1508944516169L));
            user3.setMale(true);
            user3.setCountry(User.Country.UKRAINE);


            javaRush.users.add(user);
            javaRush.users.add(user1);
            javaRush.users.add(user3);*/


            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            if (!javaRush.equals(loadedObject)) {
                throw new Exception();
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            if (!users.isEmpty()) {
                pw.println(users.size());
                for (User user : users) {
                    pw.println(user.getFirstName());
                    pw.println(user.getLastName());
                    pw.println(user.getBirthDate() == null ? null : user.getBirthDate().getTime());
                    pw.println(user.isMale());
                    pw.println(user.getCountry() == null ? null : user.getCountry().getDisplayName());
                }
            }

            pw.flush();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                int cnt = Integer.parseInt(reader.readLine());

                while (reader.ready()) {
                    for (int i = 0; i < cnt; i++) {
                        User user = new User();
                        user.setFirstName(reader.readLine());
                        user.setLastName(reader.readLine());
                        user.setBirthDate(new Date(Long.parseLong(reader.readLine())));

                        String line = reader.readLine();
                        user.setMale(line.equals("null") ? null : Boolean.valueOf(line));

                        line = reader.readLine();
                        User.Country country;
                        switch (line) {
                            case "Russia":
                                country = User.Country.RUSSIA;
                                break;
                            case "Ukraine":
                                country = User.Country.UKRAINE;
                                break;
                            default:
                                country = User.Country.OTHER;
                                break;
                        }
                        user.setCountry(line.equals("null") ? null : country);

                        this.users.add(user);
                        System.out.println(users.get(i));
                    }
                }
            } catch (Exception e) {

            }
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
