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
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("C:\\Users\\Lagster\\Desktop\\file1.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();

//            javaRush.users.add(new User());
//            javaRush.users.add(new User());
//            javaRush.users.add(new User());
//
//            javaRush.users.get(0).setFirstName("Name1");
//            javaRush.users.get(0).setLastName("LastName1");
//            Date d = new Date(1232131231231L);
//            javaRush.users.get(0).setBirthDate(d);
//            javaRush.users.get(0).setMale(true);
//            javaRush.users.get(0).setCountry(User.Country.RUSSIA);
//
//            javaRush.users.get(1).setFirstName("Name2");
//            javaRush.users.get(1).setLastName("LastName2");
//            Date d2 = new Date(123251231231L);
//            javaRush.users.get(1).setBirthDate(d2);
//            javaRush.users.get(1).setMale(false);
//            javaRush.users.get(1).setCountry(User.Country.UKRAINE);
//
//            javaRush.users.get(2).setFirstName("Name3");
//            javaRush.users.get(2).setLastName("LastName3");
//            Date d3 = new Date(1232131250231L);
//            javaRush.users.get(2).setBirthDate(d3);
//            javaRush.users.get(2).setMale(true);
//            javaRush.users.get(2).setCountry(User.Country.OTHER);

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            StringBuilder s = new StringBuilder();
            if (users.size() != 0) {
                for (User u : users) {
                    s.append(u.getFirstName());
                    s.append("|");
                    s.append(u.getLastName());
                    s.append("|");
                    s.append(u.getBirthDate().getTime());
                    s.append("|");
                    s.append(u.isMale() ? "m" : "f");
                    s.append("|");
                    s.append(u.getCountry().getDisplayedName());
                    s.append("|");
                }
            }
            outputStream.write(s.toString().getBytes());
            outputStream.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            users = new ArrayList<>();
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer, 0, inputStream.available());
            String[] s = new String(buffer).split("\\|");
            if (s.length != 1) {
                for (int i = 0; i < s.length; i += 5) {
                    users.add(new User());
                    users.get(users.size() - 1).setFirstName(s[i]);
                    users.get(users.size() - 1).setLastName(s[i + 1]);
                    users.get(users.size() - 1).setBirthDate(new Date(Long.valueOf(s[i + 2])));
                    users.get(users.size() - 1).setMale(s[i + 3].equals("m"));
                    users.get(users.size() - 1).setCountry(User.Country.valueOf(s[i + 4].toString().toUpperCase()));
                }
            }
            inputStream.close();
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
